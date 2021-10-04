-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 14, 2021 lúc 01:07 PM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 7.3.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `linhkienmaytinh3`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `brand`
--

CREATE TABLE `brand` (
  `id_brand` int(11) NOT NULL,
  `ten_brand` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `brand`
--

INSERT INTO `brand` (`id_brand`, `ten_brand`) VALUES
(1, 'ASUS'),
(2, 'DELL'),
(3, 'HP'),
(4, 'MACBOOK'),
(5, 'SAMSUNG');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethd`
--

CREATE TABLE `chitiethd` (
  `stt` int(11) NOT NULL,
  `id_hd` int(11) NOT NULL,
  `id_sp` int(11) NOT NULL,
  `soluong` int(11) DEFAULT NULL,
  `gia` double DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitiethd`
--

INSERT INTO `chitiethd` (`stt`, `id_hd`, `id_sp`, `soluong`, `gia`, `subtotal`, `created_at`, `updated_at`) VALUES
(2, 1, 7, 2, 1000000, 2000000, '2021-05-11 04:40:22', '2021-05-14 11:51:17'),
(3, 1, 3, 1, 2000000, 2000000, '2021-05-11 04:40:26', '2021-05-14 11:51:30'),
(4, 2, 3, 2, 2000000, 4000000, '2021-05-11 05:59:29', '2021-05-11 12:59:29'),
(5, 2, 9, 1, 2000000, 2000000, '2021-05-11 05:59:29', '2021-05-14 11:51:37'),
(6, 3, 5, 2, 1000000, 2000000, '2021-05-11 06:43:34', '2021-05-14 11:51:42'),
(7, 3, 8, 1, 2000000, 2000000, '2021-05-11 06:43:36', '2021-05-14 11:51:48'),
(8, 4, 6, 1, 1000000, 1000000, '2021-05-11 06:46:52', '2021-05-11 13:46:52'),
(9, 4, 3, 1, 2000000, 2000000, '2021-05-11 06:46:53', '2021-05-11 13:46:53'),
(10, 5, 6, 3, 1000000, 3000000, '2021-05-11 12:26:44', '2021-05-11 19:26:44'),
(11, 5, 6, 2, 2000000, 4000000, '2021-05-11 12:26:44', '2021-05-11 19:26:44'),
(12, 6, 6, 1, 2000000, 2000000, '2021-05-14 05:40:04', '2021-05-14 12:40:04'),
(13, 7, 3, 4, 2000000, 8000000, '2021-05-14 07:59:51', '2021-05-14 14:59:51'),
(14, 7, 6, 4, 1000000, 4000000, '2021-05-14 07:59:51', '2021-05-14 14:59:51');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctsp`
--

CREATE TABLE `ctsp` (
  `stt` int(11) NOT NULL,
  `id_sp` int(11) NOT NULL,
  `cpu` varchar(200) DEFAULT NULL,
  `gpu` varchar(100) DEFAULT NULL,
  `ram` int(11) DEFAULT NULL,
  `disk` int(11) DEFAULT NULL,
  `gia` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `ctsp`
--

INSERT INTO `ctsp` (`stt`, `id_sp`, `cpu`, `gpu`, `ram`, `disk`, `gia`) VALUES
(3, 6, 'core i6', 'null', 4, 4, 1000000),
(4, 6, 'core i2', 'null', 4, 8, 2000000),
(5, 3, 'core i3', 'null', 4, 8, 2000000),
(6, 3, 'core', '12', 34, 45, 34),
(7, 4, 'core i4', NULL, 213, 213, 123),
(8, 4, 'core', NULL, 213, 213, 123);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `id_hd` int(10) NOT NULL,
  `id_nv` int(10) NOT NULL,
  `id_kh` int(10) NOT NULL,
  `id_km` int(10) NOT NULL,
  `total_hd` float NOT NULL,
  `created_at` date NOT NULL DEFAULT current_timestamp(),
  `updated_at` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`id_hd`, `id_nv`, `id_kh`, `id_km`, `total_hd`, `created_at`, `updated_at`) VALUES
(1, 3, 3, 1, 4000000, '2021-05-11', '2021-05-11'),
(2, 3, 2, 1, 6000000, '2021-05-11', '2021-05-11'),
(3, 2, 1, 1, 4000000, '2021-05-11', '2021-05-11'),
(4, 2, 2, 1, 3000000, '2021-05-11', '2021-05-11'),
(5, 2, 2, 1, 7000000, '2021-05-11', '2021-05-11'),
(6, 1, 1, 1, 2000000, '2021-05-14', '2021-05-14'),
(7, 1, 1, 1, 12000000, '2021-05-14', '2021-05-14');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `id_kh` int(10) NOT NULL,
  `ho_kh` varchar(50) NOT NULL,
  `ten_kh` varchar(50) NOT NULL,
  `phone_kh` varchar(11) NOT NULL,
  `address_kh` varchar(255) NOT NULL,
  `gender` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`id_kh`, `ho_kh`, `ten_kh`, `phone_kh`, `address_kh`, `gender`) VALUES
(1, 'nguyen van', 'a', '01234567893', 'Nhà ở đâu đó trên trái đất', 'Nam'),
(2, 'Nguyen Thi', 'B', '01876543219', 'Nhà ở đâu đó ở Việt Nam', 'Nữ'),
(3, 'Tran Van', 'A', '01593574569', 'Nhà ở gần Trái Đất', 'Nam');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `id_km` int(10) NOT NULL,
  `ten_km` varchar(255) NOT NULL,
  `ngaybd` date NOT NULL,
  `ngaykt` date NOT NULL,
  `phantram` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `khuyenmai`
--

INSERT INTO `khuyenmai` (`id_km`, `ten_km`, `ngaybd`, `ngaykt`, `phantram`) VALUES
(1, 'aaa', '0000-00-00', '0000-00-00', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `ten_nv` varchar(50) NOT NULL,
  `ho_nv` varchar(50) NOT NULL,
  `id_nv` int(10) NOT NULL,
  `phone_nv` varchar(11) NOT NULL,
  `address_nv` varchar(255) NOT NULL,
  `luong_nv` float NOT NULL,
  `gender` varchar(5) NOT NULL,
  `password_nv` varchar(15) NOT NULL,
  `chucvu_nv` text NOT NULL,
  `user` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`ten_nv`, `ho_nv`, `id_nv`, `phone_nv`, `address_nv`, `luong_nv`, `gender`, `password_nv`, `chucvu_nv`, `user`) VALUES
('Chuong', 'Nguyen', 1, '09837654321', '144/22/33/44', 9000, 'Nam', '123', 'Chủ', 'chuong'),
('Tri Dat', 'Bui', 2, '09128765432', '144/22/33/44', 90000, 'Nam', 'dat123', 'Chủ', 'dat'),
('Duy', 'Pham', 3, '09876543221', '144/22/33/44', 9000, 'Nam', 'duy123', 'Nhân viên', 'duy'),
('nguyen', 'chhoung', 4, '01234567891', '45', 12354, 'Nam', '123', 'Quản lý', 'choung');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id_sp` int(10) NOT NULL,
  `ten_sp` varchar(255) NOT NULL,
  `hinhanh_sp` text NOT NULL,
  `soluong_sp` int(11) NOT NULL,
  `loai_sp` varchar(255) NOT NULL,
  `id_brand` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id_sp`, `ten_sp`, `hinhanh_sp`, `soluong_sp`, `loai_sp`, `id_brand`) VALUES
(1, 'ASUS ZENBOOK', '5 Best HP i7 Laptops.png', 30, 'laptop', 1),
(2, 'ASUS TUF DASH', 'asusrogphone2.png', 50, 'laptop', 1),
(3, 'DELL INSPIRON', '', 10, 'laptop', 2),
(4, 'SAMSUNG D.A.T', '', 10, '0', 5),
(5, 'macbookm1', 'Microsoft’s 13_5-inch Surface Book 3 puts modern guts in a dated design.jpg', 23, '0', 4),
(6, 'SAMSUNG SANG SING', 'Laptop ASUS L210 Ultra Thin Laptop.png', 21, '0', 5),
(7, 'Laptop hpp', '', 12, '0', 1),
(8, 'DELL INSPIRON', '', 10, '0', 1),
(9, 'Laptop hpp', '', 12, '0', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`id_brand`);

--
-- Chỉ mục cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD PRIMARY KEY (`stt`,`id_hd`,`id_sp`),
  ADD KEY `fk_cthd_id_hd` (`id_hd`),
  ADD KEY `fk_cthd_id_sp` (`id_sp`);

--
-- Chỉ mục cho bảng `ctsp`
--
ALTER TABLE `ctsp`
  ADD PRIMARY KEY (`stt`,`id_sp`),
  ADD KEY `fk_ctsp_id_sp` (`id_sp`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`id_hd`),
  ADD KEY `id_nv` (`id_nv`),
  ADD KEY `id_kh` (`id_kh`),
  ADD KEY `id_km` (`id_km`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`id_kh`);

--
-- Chỉ mục cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`id_km`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`id_nv`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id_sp`),
  ADD KEY `id_brand` (`id_brand`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `brand`
--
ALTER TABLE `brand`
  MODIFY `id_brand` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  MODIFY `stt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `ctsp`
--
ALTER TABLE `ctsp`
  MODIFY `stt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `id_kh` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  MODIFY `id_km` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `id_nv` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD CONSTRAINT `fk_cthd_id_hd` FOREIGN KEY (`id_hd`) REFERENCES `hoadon` (`id_hd`),
  ADD CONSTRAINT `fk_cthd_id_sp` FOREIGN KEY (`id_sp`) REFERENCES `sanpham` (`id_sp`);

--
-- Các ràng buộc cho bảng `ctsp`
--
ALTER TABLE `ctsp`
  ADD CONSTRAINT `fk_ctsp_id_sp` FOREIGN KEY (`id_sp`) REFERENCES `sanpham` (`id_sp`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`id_kh`) REFERENCES `khachhang` (`id_kh`),
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`id_km`) REFERENCES `khuyenmai` (`id_km`),
  ADD CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`id_nv`) REFERENCES `nhanvien` (`id_nv`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`id_brand`) REFERENCES `brand` (`id_brand`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
