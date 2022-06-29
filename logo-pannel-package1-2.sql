USE SHOPOFQA
GO
---------------HỦY BẢNG------------------------------------------------
DROP TABLE SERVERIMG
DROP TABLE SERVERIMGSIGNIN
---------------TẠO BẢNG VÀ LƯU HÌNH ẢNH ICON CHO APP-------------------
CREATE TABLE SERVERIMG
(
IMGID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
countid INT IDENTITY,
IMGNAME VARCHAR(MAX) DEFAULT NULL,
IMGDATA IMAGE DEFAULT NULL,
)
--
CREATE TABLE SERVERIMGSIGNIN
(
IMGID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
countid INT IDENTITY,
IMGNAME VARCHAR(MAX) DEFAULT NULL,
IMGDATA IMAGE DEFAULT NULL,
)
---------------THÊM HÌNH ẢNH VÀ ICON-----------------------------------
GO

INSERT INTO dbo.SERVERIMG
(
    IMGID,
    IMGNAME,
    IMGDATA
)
VALUES
(DEFAULT,'logoshop.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\logoshop.png', SINGLE_BLOB) AS img)),
(DEFAULT,'logoshopname.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\logoshopname.png', SINGLE_BLOB) AS img)),
(DEFAULT,'logosearch.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\logosearch.png', SINGLE_BLOB) AS img)),
(DEFAULT,'logobag.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\logobag.png', SINGLE_BLOB) AS img)),
(DEFAULT,'panel1.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\panel1.png', SINGLE_BLOB) AS img)),
(DEFAULT,'panel2.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\panel2.png', SINGLE_BLOB) AS img)),
(DEFAULT,'logo1k.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\logo1k.png', SINGLE_BLOB) AS img)),
(DEFAULT,'logoCard.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\logoCard.png', SINGLE_BLOB) AS img)),
(DEFAULT,'logoCheap.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\logoCheap.png', SINGLE_BLOB) AS img)),
(DEFAULT,'logoFreeShip.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\logoFreeShip.png', SINGLE_BLOB) AS img)),
(DEFAULT,'logoLux.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\logoLux.png', SINGLE_BLOB) AS img)),
(DEFAULT,'pannel3.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\pannel3.png', SINGLE_BLOB) AS img)),
(DEFAULT,'catalogies1.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\catalogies1.png', SINGLE_BLOB) AS img)),
(DEFAULT,'catalogies2.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\catalogies2.png', SINGLE_BLOB) AS img)),
(DEFAULT,'catalogies3.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\catalogies3.png', SINGLE_BLOB) AS img)),
(DEFAULT,'catalogies4.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\catalogies4.png', SINGLE_BLOB) AS img)),
(DEFAULT,'catalogies5.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\catalogies5.png', SINGLE_BLOB) AS img)),
(DEFAULT,'catalogies6.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\catalogies6.png', SINGLE_BLOB) AS img)),
(DEFAULT,'catalogies7.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\catalogies7.png', SINGLE_BLOB) AS img)),
(DEFAULT,'catalogies8.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\catalogies8.png', SINGLE_BLOB) AS img)),
(DEFAULT,'catalogies9.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\catalogies9.png', SINGLE_BLOB) AS img)),
(DEFAULT,'catalogies10.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\catalogies10.png', SINGLE_BLOB) AS img)),
(DEFAULT,'catalogies11.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\catalogies11.png', SINGLE_BLOB) AS img)),
(DEFAULT,'catalogies12.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\catalogies12.png', SINGLE_BLOB) AS img)),
(DEFAULT,'logoSansales1.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\logoSansales1.png', SINGLE_BLOB) AS img)),
(DEFAULT,'logoSansales2.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\logoSansales2.png', SINGLE_BLOB) AS img)),
(DEFAULT,'slide1.jpg',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\slide\slide1.jpg', SINGLE_BLOB) AS img)),
(DEFAULT,'slide2.jpg',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\slide\slide2.jpg', SINGLE_BLOB) AS img)),
(DEFAULT,'slide3.jpg',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\slide\slide3.png', SINGLE_BLOB) AS img)),
(DEFAULT,'phieuloc.jpg',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3\phieuloc.jpg', SINGLE_BLOB) AS img))

---
GO
INSERT INTO dbo.SERVERIMGSIGNIN
(
    IMGID,
    IMGNAME,
    IMGDATA
)
VALUES
(DEFAULT,'logoshop.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3-signin\logoshop.png', SINGLE_BLOB) AS img)),
(DEFAULT,'content.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3-signin\content.png', SINGLE_BLOB) AS img)),
(DEFAULT,'footer.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3-signin\footer.png', SINGLE_BLOB) AS img)),
(DEFAULT,'icon-fb.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3-signin\icon-fb.png', SINGLE_BLOB) AS img)),
(DEFAULT,'icon-gg.png',(SELECT * FROM OPENROWSET(BULK 'C:\Users\PC\Desktop\shoppee-cover-java\DesktopApp\ServerDesktopApplication\icon-jav3-signin\icon-gg.png', SINGLE_BLOB) AS img))


SELECT * FROM dbo.SERVERIMGSIGNIN 
ORDER BY COuntid ASC
SELECT * FROM dbo.SERVERIMG
ORDER BY COuntid ASC