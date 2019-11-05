package com.leasing.common.utils.base;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.xerces.dom.AttrImpl;
import org.apache.xerces.dom.DocumentImpl;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
/**
 * @project:leasing-cloud
 * @date:2019/11/4
 * @author:wangjc@yonyou.com
 * @description:xml解析工具类
 **/
public class XMLUtils {
    private static DocumentBuilderFactory dbf = getDOMFactory();
    static ThreadLocal dbcache = new ThreadLocal() {
        protected Object initialValue() {
            try {
                return dbf.newDocumentBuilder();
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
    };

    public static DocumentBuilder getDocumentBuilder() {
        return (DocumentBuilder) dbcache.get();
    }

    private static DocumentBuilderFactory getDOMFactory() {
        DocumentBuilderFactory newdbf = new org.apache.xerces.jaxp.DocumentBuilderFactoryImpl();
        // DocumentBuilderFactory newdbf = DocumentBuilderFactory.newInstance();
        newdbf.setNamespaceAware(true);
        return newdbf;
    }

    /**
     * Copies the source tree into the specified place in a destination
     * tree. The source node and its children are appended as children
     * of the destination node.
     * <p>
     * <em>Note:</em> This is an iterative implementation.
     */
    public static void copyInto(Node src, Node dest) throws DOMException {

        // get node factory
        Document factory = dest.getOwnerDocument();
        boolean domimpl = factory instanceof DocumentImpl;

        // placement variables
        Node start = src;
        Node parent = src;
        Node place = src;

        // traverse source tree
        while (place != null) {

            // copy this node
            Node node = null;
            int type = place.getNodeType();
            switch (type) {
                case Node.CDATA_SECTION_NODE: {
                    node = factory.createCDATASection(place.getNodeValue());
                    break;
                }
                case Node.COMMENT_NODE: {
                    node = factory.createComment(place.getNodeValue());
                    break;
                }
                case Node.ELEMENT_NODE: {
                    Element element = factory.createElement(place.getNodeName());
                    node = element;
                    NamedNodeMap attrs = place.getAttributes();
                    int attrCount = attrs.getLength();
                    for (int i = 0; i < attrCount; i++) {
                        Attr attr = (Attr) attrs.item(i);
                        String attrName = attr.getNodeName();
                        String attrValue = attr.getNodeValue();
                        element.setAttribute(attrName, attrValue);
                        if (domimpl && !attr.getSpecified()) {
                            ((AttrImpl) element.getAttributeNode(attrName)).setSpecified(false);
                        }
                    }
                    break;
                }
                case Node.ENTITY_REFERENCE_NODE: {
                    node = factory.createEntityReference(place.getNodeName());
                    break;
                }
                case Node.PROCESSING_INSTRUCTION_NODE: {
                    node = factory.createProcessingInstruction(place.getNodeName(),
                            place.getNodeValue());
                    break;
                }
                case Node.TEXT_NODE: {
                    node = factory.createTextNode(place.getNodeValue());
                    break;
                }
                default: {
                    throw new IllegalArgumentException("can't copy node type, " +
                            type + " (" +
                            node.getNodeName() + ')');
                }
            }
            dest.appendChild(node);

            // iterate over children
            if (place.hasChildNodes()) {
                parent = place;
                place = place.getFirstChild();
                dest = node;
            }

            // advance
            else {
                place = place.getNextSibling();
                while (place == null && parent != start) {
                    place = parent.getNextSibling();
                    parent = parent.getParentNode();
                    dest = dest.getParentNode();
                }
            }

        }

    } // copyInto(Node,Node)

    /** Finds and returns the first child element node. */
    public static Element getFirstChildElement(Node parent) {

        // search for node
        Node child = parent.getFirstChild();
        while (child != null) {
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                return (Element) child;
            }
            child = child.getNextSibling();
        }

        // not found
        return null;

    } // getFirstChildElement(Node):Element

    /** Finds and returns the last child element node. */
    public static Element getLastChildElement(Node parent) {

        // search for node
        Node child = parent.getLastChild();
        while (child != null) {
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                return (Element) child;
            }
            child = child.getPreviousSibling();
        }

        // not found
        return null;

    } // getLastChildElement(Node):Element

    /** Finds and returns the next sibling element node. */
    public static Element getNextSiblingElement(Node node) {

        // search for node
        Node sibling = node.getNextSibling();
        while (sibling != null) {
            if (sibling.getNodeType() == Node.ELEMENT_NODE) {
                return (Element) sibling;
            }
            sibling = sibling.getNextSibling();
        }

        // not found
        return null;

    } // getNextSiblingElement(Node):Element


    /** Finds and returns the first child node with the given name. */
    public static Element getFirstChildElement(Node parent, String elemName) {

        // search for node
        Node child = parent.getFirstChild();
        while (child != null) {
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                if (child.getNodeName().equals(elemName)) {
                    return (Element) child;
                }
            }
            child = child.getNextSibling();
        }

        // not found
        return null;

    } // getFirstChildElement(Node,String):Element

    /** Finds and returns the last child node with the given name. */
    public static Element getLastChildElement(Node parent, String elemName) {

        // search for node
        Node child = parent.getLastChild();
        while (child != null) {
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                if (child.getNodeName().equals(elemName)) {
                    return (Element) child;
                }
            }
            child = child.getPreviousSibling();
        }

        // not found
        return null;

    } // getLastChildElement(Node,String):Element

    /** Finds and returns the next sibling node with the given name. */
    public static Element getNextSiblingElement(Node node, String elemName) {

        // search for node
        Node sibling = node.getNextSibling();
        while (sibling != null) {
            if (sibling.getNodeType() == Node.ELEMENT_NODE) {
                if (sibling.getNodeName().equals(elemName)) {
                    return (Element) sibling;
                }
            }
            sibling = sibling.getNextSibling();
        }

        // not found
        return null;

    } // getNextSiblingdElement(Node,String):Element

    /**
     * Returns the concatenated child text of the specified node.
     * This method only looks at the immediate children of type
     * <code>Node.TEXT_NODE</code> or the children of any child
     * node that is of type <code>Node.CDATA_SECTION_NODE</code>
     * for the concatenation.
     *
     * @param node The node to look at.
     */
    public static String getChildText(Node node) {

        // is there anything to do?
        if (node == null) {
            return null;
        }

        // concatenate children text
        StringBuffer str = new StringBuffer();
        Node child = node.getFirstChild();
        while (child != null) {
            short type = child.getNodeType();
            if (type == Node.TEXT_NODE) {
                str.append(child.getNodeValue());
            } else if (type == Node.CDATA_SECTION_NODE) {
                str.append(getChildText(child));
            }
            child = child.getNextSibling();
        }

        // return text value
        return str.toString();

    } // getChildText(Node):String

    /**
     * 获取简单元素Element的文本值,如果没有文本节点,返回null
     *(注意和getChildText方法的区别)
     * @param
     */
    public static String getElementText(Element ele) {

        // is there anything to do?
        if (ele == null) {
            return null;
        }
        // get children text
        Node child = ele.getFirstChild();
        if (child != null) {
            short type = child.getNodeType();
            if (type == Node.TEXT_NODE) {
                return child.getNodeValue();
            }
        }
        // return text value
        return null;
    } // getChildText(Node):String


    public static String getFirstChildElementText(Node node) {
        return getElementText(getFirstChildElement(node));
    }

    public static String getLastChildElementText(Node node) {
        return getElementText(getLastChildElement(node));
    }

    public static String getNextSiblingElementText(Node node) {
        return getElementText(getNextSiblingElement(node));
    }


    public static String getFirstChildElementText(Node node, String elemName) {
        return getElementText(getFirstChildElement(node, elemName));
    }

    public static String getLastChildElementText(Node node, String elemName) {
        return getElementText(getLastChildElement(node, elemName));
    }

    public static String getNextSiblingElementText(Node node, String elemName) {
        return getElementText(getNextSiblingElement(node, elemName));
    }

    public static Element createLeafElement(Document doc, String eleName, String text) {
        Element ele = doc.createElement(eleName);
        if(text!=null){
            ele.appendChild(doc.createTextNode(text));
        }
        return ele;
    }

    public static void addChildElement(Element element, String child_ele_name, String text) {
        Document doc = element.getOwnerDocument();
        Element sub_element = createLeafElement(doc, child_ele_name, text);
        element.appendChild(sub_element);
    }
}