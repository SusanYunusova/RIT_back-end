INSERT INTO `customers` (`id_customer`,`code`,`max_payment`,`name`,`paternal_name`,`surname`) VALUES
 (1,'B1','500.00','Bucky','daddy','Robert'),
 (2,'J1','300.00','John','Jim','Doe'),
 (3,'A1','700.00','Ali','Vali','Somthing'),
 (4,'C1','600.00','Ceremy','jerom','cj');

INSERT INTO `payment_history` (`id`,`deadline`,`id_customer`,`min_payment_amount`,`paid_day`,`payment_amount`) VALUES
 (1,'2020-01-12',1,'300.00','2020-01-14','400.00'),
 (2,'2019-05-06',2,'200.00','2019-05-06','200.00'),
 (3,'2020-01-07',2,'500.00','2020-01-08','500.00'),
 (4,'2020-02-08',3,'700.00','2020-02-06','700.00'),
 (5,'2020-03-07',4,'600.00','2020-03-10','500.00');


