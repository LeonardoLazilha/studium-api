USE master;
GO

ALTER DATABASE studium SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
GO

ALTER DATABASE studium MODIFY NAME = STUDIUM;
GO

ALTER DATABASE STUDIUM SET MULTI_USER;
GO

USE studium;
GO

EXEC sp_rename 'student', 'STUDENT';
GO