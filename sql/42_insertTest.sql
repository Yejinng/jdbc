SELECT * FROM book;

INSERT INTO book
     VALUES (10,
             '토지10',
             SYSDATE,
             '대여가능',
             1);

COMMIT;