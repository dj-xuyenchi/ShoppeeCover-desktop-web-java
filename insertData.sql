USE SHOPOFQA
GO
-----------------data--------------------
----Account
INSERT INTO dbo.ACCOUNT
VALUES
('4D81EAC3-924F-4E89-B38C-0B87ECC5F026',DEFAULT,DEFAULT,'0968491797','yeuHien123','C506315C-FC60-4CC7-87E3-DDDA16F8780A','12C8761C-4AE2-4A39-AD3F-F573DE15C85D',DEFAULT,DEFAULT,DEFAULT,DEFAULT,DEFAULT,10000000,DEFAULT),
('61842939-A992-45E3-B154-1DA8762693D5',DEFAULT,'cauvongsociu',DEFAULT,'yeuHien123','C506315C-FC60-4CC7-87E3-DDDA16F8780A','E68C67E6-CA3E-4208-B23D-FF6092E56ACC',DEFAULT,DEFAULT,DEFAULT,DEFAULT,DEFAULT,100,DEFAULT)
----------------
----Shop
INSERT INTO dbo.SHOP
VALUES
('75A8D78F-0571-43A7-AEE1-04C3F003CEBE','4D81EAC3-924F-4E89-B38C-0B87ECC5F026',N'B� Xinh','EBD7D256-AE3B-4072-AEF6-15A1DA065562'),
('2A6F155A-477D-4E8F-BEEE-9189D1B2651B','61842939-A992-45E3-B154-1DA8762693D5',N'MayTree','0CCCCB5B-A44E-4AF2-8209-921F63D10EFB')
----Product