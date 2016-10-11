select * from book;
rollback;
update book set title = '', state = '대여가능' where no = 12;