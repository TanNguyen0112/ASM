-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2015-12-02 14:27:31.537




-- tables
-- Table: LopHoc
CREATE TABLE LopHoc (
    MaLop text  NOT NULL,
    TenLop text  NOT NULL,
    CONSTRAINT LopHoc_pk PRIMARY KEY (MaLop)
);



-- Table: Student
CREATE TABLE Student (
    MaSV text  NOT NULL,
    TenSV text  NOT NULL,
    MaLop text  NOT NULL,
    LopHoc_MaLop text  NOT NULL,
    CONSTRAINT Student_pk PRIMARY KEY (MaSV)
);





-- foreign keys
-- Reference:  Student_LopHoc (table: Student)


ALTER TABLE Student ADD CONSTRAINT Student_LopHoc 
    FOREIGN KEY (LopHoc_MaLop)
    REFERENCES LopHoc (MaLop)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;




-- thêm du lieu lop hoc
INSERT INTO LopHoc VALUES('PT9301','Lập Trình Di Động');
INSERT INTO LopHoc VALUES('PT10103','Thiết Kế Đồ Họa');
INSERT INTO LopHoc VALUES('PT10104','Thiết Kế Web');
INSERT INTO LopHoc VALUES('PT10105','An Ninh Mạng');
INSERT INTO LopHoc VALUES('PT9302','Kế Toán');


-- thêm du lieu sinh viên
INSERT INTO Student VALUES('PS02200','Nguyen Hoang Tan','Lập Trình Di Động');
INSERT INTO Student VALUES('PS02201','Nguyen Van Nam','Thiết Kế Đồ Họa');
INSERT INTO Student VALUES('PS02202','Nguyen Tran Trung Nguyen','Thiết Kế Web');
INSERT INTO Student VALUES('PS02203','Le Ly Gia Phat','An Ninh Mạng');
INSERT INTO Student VALUES('PS02204','Tran Trung Hau','Kế Toán');




-- End of file.

