select count(0)
  from (select t.*
          from yls_customer t
        
         where 
            t.customer_manager = '1003A910000000008U8N' and t.if_new = 0
        union
        select t.*
          from yls_customer t
          join yls_customer_auth b
            on b.pk_customer = t.pk_customer
         where b.auth_pk_user = '1003A910000000008U8N' and t.if_new = 0)




select *
  from yls_customer t
 where t.pk_customer in (
                         
                         select t.pk_customer
                           from yls_customer t
                          where t.customer_manager = '1003A910000000008U8N'
                            and t.if_new = 0)
    or t.pk_customer in (
                         
                         select b.pk_customer
                           from yls_customer_auth b
                          where b.auth_pk_user = '1003A910000000008U8N')







SELECT DECODE(n,1,customer_name,2*0.5) 
  FROM (select customer_name  from yls_customer where customer_manager = '1003A910000000008U8N' and if_new  =0)
      ,(SELECT LEVEL n FROM DUAL CONNECT BY LEVEL<=2)
