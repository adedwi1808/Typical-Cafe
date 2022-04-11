-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Waktu pembuatan: 30 Nov 2021 pada 14.19
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 7.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `typical_cafe`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `inventory`
--

CREATE TABLE `inventory` (
  `id_inventory` int(10) NOT NULL,
  `nama_inventory` varchar(30) NOT NULL,
  `jumlah_inventory` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `inventory`
--

INSERT INTO `inventory` (`id_inventory`, `nama_inventory`, `jumlah_inventory`) VALUES
(1, 'Coffe', 78),
(2, 'Dark Roast Coffee', 84),
(3, 'White Sugar', 89),
(4, 'Unsweetened Cocoa Powder', 24),
(5, 'Milk', 71),
(6, 'Caramel Sauce', 70),
(7, 'Vanilla Syrup', 55),
(8, 'Hazelnut Syrup', 55),
(9, 'Brown Sugar', 75),
(10, 'Vanilla Extract', 40),
(11, 'Caramel Sauce', 57),
(12, 'Lemon', 21),
(13, 'Water', 154),
(14, 'Ice Cube', 64);

-- --------------------------------------------------------

--
-- Struktur dari tabel `menu`
--

CREATE TABLE `menu` (
  `id_menu` int(10) NOT NULL,
  `nama_menu` varchar(30) NOT NULL,
  `kategori_menu` varchar(30) NOT NULL,
  `harga_menu` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `menu`
--

INSERT INTO `menu` (`id_menu`, `nama_menu`, `kategori_menu`, `harga_menu`) VALUES
(1, 'Coffee Mocca', 'Coffee Barista', 30000),
(2, 'Ice Hazelnut Latte', 'Ice Coffee', 30000),
(3, 'Coffee Latte', 'Coffee Barista', 35000),
(4, 'Cappucino', 'Coffee Barista', 30000),
(5, 'Americano', 'Coffee Barista', 30000),
(6, 'Espresso', 'Coffe Barista', 33000),
(7, 'Ice Caramel Latte', 'Ice Coffee', 38000),
(8, 'Ice Vanilla Latte', 'Ice Coffee', 35000),
(9, 'Ice Coffee Latte', 'Ice Coffee', 38000),
(10, 'Ice Cappucino', 'Ice Coffee', 35000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_user` int(10) NOT NULL,
  `nama_pelanggan` varchar(20) NOT NULL,
  `menu_coffeBarista` varchar(20) DEFAULT NULL,
  `jumlah_coffeBarista` int(10) DEFAULT NULL,
  `menu_iceCoffe` varchar(20) DEFAULT NULL,
  `jumlah_iceCoffe` int(10) DEFAULT NULL,
  `total_harga` int(30) NOT NULL,
  `tanggal` date NOT NULL,
  `waktu` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_user`, `nama_pelanggan`, `menu_coffeBarista`, `jumlah_coffeBarista`, `menu_iceCoffe`, `jumlah_iceCoffe`, `total_harga`, `tanggal`, `waktu`) VALUES
(1, 2, 'Virgi', 'Coffee Mocca', 4, 'Ice Hazelnut Latte', 3, 210000, '2021-10-01', '14:53:51'),
(2, 2, 'James', 'Coffee Mocca', 6, NULL, NULL, 180000, '2021-10-01', '14:59:56'),
(3, 2, 'Maudy', 'Coffee Mocca', 5, 'Ice Hazelnut Latte', 6, 330000, '2021-10-01', '15:00:27'),
(4, 2, 'harry', 'Espresso', 1, NULL, NULL, 33000, '2021-10-01', '17:59:01'),
(5, 2, 'David', 'Espresso', 1, NULL, NULL, 33000, '2021-10-06', '18:00:03'),
(6, 2, 'Brand', 'Coffee Mocca', 2, NULL, NULL, 60000, '2021-11-30', '18:55:52'),
(7, 2, 'Meggy', 'Cappucino', 2, 'Ice Coffee Latte', 2, 136000, '2021-11-30', '18:57:13'),
(8, 2, 'Frans', 'Coffee Mocca', 2, 'Ice Vanilla Latte', 4, 200000, '2021-11-30', '19:01:36'),
(9, 2, 'Richard', 'Coffee Latte', 2, 'Ice Coffee Latte', 2, 146000, '2021-11-30', '19:02:42'),
(10, 2, 'Chris', 'Coffee Latte', 3, 'Ice Vanilla Latte', 2, 175000, '2021-11-30', '19:46:41'),
(11, 2, 'Boss', 'Coffee Mocca', 2, 'Ice Vanilla Latte', 2, 130000, '2021-11-30', '19:49:23'),
(12, 2, 'Lany', 'Coffee Mocca', 2, 'Ice Coffee Latte', 2, 136000, '2021-11-30', '19:51:44'),
(13, 2, 'Lebrand', 'Espresso', 1, 'Ice Cappucino', 5, 208000, '2021-11-30', '19:53:03'),
(14, 2, 'Harry', NULL, NULL, 'Ice Cappucino', 5, 175000, '2021-11-30', '19:53:31'),
(15, 2, 'Shinta', 'Coffee Mocca', 2, NULL, NULL, 60000, '2021-11-30', '20:03:11');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` int(10) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `nama`, `username`, `password`, `type`) VALUES
(1, 'Virginia', 'virgi', 'virgi', 'Admin'),
(2, 'Lany', 'lany', 'lany', 'Kasir'),
(3, 'Honne', 'honne', 'honne', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`id_inventory`);

--
-- Indeks untuk tabel `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id_menu`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_user` (`id_user`) USING BTREE;

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `inventory`
--
ALTER TABLE `inventory`
  MODIFY `id_inventory` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT untuk tabel `menu`
--
ALTER TABLE `menu`
  MODIFY `id_menu` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
