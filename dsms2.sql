-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2021 at 04:34 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dsms2`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart_item`
--

CREATE TABLE `cart_item` (
  `id` varchar(255) NOT NULL,
  `created_at` bigint(20) NOT NULL,
  `updated_at` bigint(20) NOT NULL,
  `item_count` int(11) NOT NULL,
  `item_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `item_entity`
--

CREATE TABLE `item_entity` (
  `id` varchar(255) NOT NULL,
  `created_at` bigint(20) NOT NULL,
  `updated_at` bigint(20) NOT NULL,
  `desciption` varchar(255) NOT NULL,
  `image_url` text NOT NULL,
  `item_category` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item_entity`
--

INSERT INTO `item_entity` (`id`, `created_at`, `updated_at`, `desciption`, `image_url`, `item_category`, `name`, `price`) VALUES
('07958fcb-6098-4e59-9286-f97957fce6d0', 1619956728, 1619956728, 'a cctv camera with 720p video recording', 'C:\\Users\\Mahaj\\dsms\\cctv camera.jpg', 'ELECTRONICS', 'cctv camera', 500),
('0b50c2c0-1244-4915-a32a-7dd842912874', 1619957371, 1619957371, '1 kg', 'C:\\Users\\Mahaj\\dsms\\51pGKvrLroL._AC_SX522_.jpg', 'GROCERY', 'rice', 300),
('147ab838-849b-4922-a5d7-05c3e33333dc', 1619956350, 1619956350, 'sports t shirt', 'C:\\Users\\Mahaj\\dsms\\mens-printed-round-neck-t-shirt-sports t shirt colour.jpg', 'GARMENTS', 'sparks sweat shirt', 695),
('1784cdd3-ff51-4efc-95b5-9096d5b2e493', 1619954773, 1619954773, 'round neck fortnite design', 'C:\\Users\\Mahaj\\dsms\\mens-printed-round-neck-t-shirt-fortnite-colour.jpg', 'GARMENTS', 'highlander tshirt', 380),
('201a451e-53c7-4f49-8a68-3715d86977fe', 1619957463, 1619957463, 'running shoes', 'C:\\Users\\Mahaj\\dsms\\hfi49-8-adidas-cblack-ftwwht-cblack-original-imafgpqzahqnnywx.jpg', 'SHOES', 'addidas shoes', 300),
('2096097e-2cae-473d-b07b-bfea5d30a85c', 1619956943, 1619956943, 'hand blender with high power', 'C:\\Users\\Mahaj\\dsms\\hand blender.jpg', 'ELECTRONICS', 'hand blender', 300),
('26b64290-814a-4091-9fc8-4496c80b12a5', 1619957649, 1619957649, 'running shoes', 'C:\\Users\\Mahaj\\dsms\\71ilzo0z50lul1100-254464_l.jpg', 'SHOES', 'asian shoes', 999),
('2830651d-171e-4d10-9b94-2472e27ec59f', 1619957561, 1619957561, 'running shoes', 'C:\\Users\\Mahaj\\dsms\\10-rider-12cwht-asian-original-imafvyjsnzvbjxku.jpeg', 'SHOES', 'addidas shoes', 300),
('2a706080-f61f-4576-94cc-48ec8a055ad3', 1619956844, 1619956844, 'digital watch with buttons', 'C:\\Users\\Mahaj\\dsms\\coolest-best-latest-top-new-fun-high-technology-electronic-gadgets-mobile_phone_watch1.jpg', 'ELECTRONICS', 'watch', 999),
('30e9f18e-2989-4e2d-9e73-c9519dd4e976', 1619957143, 1619957143, 'pack of 4', 'C:\\Users\\Mahaj\\dsms\\70-masala-instant-noodles-maggi-original-imafnf4egpdjr4mq.jpeg', 'GROCERY', 'maggie', 100),
('52d71eb7-eee0-4d2f-9397-65aea722128b', 1619957292, 1619957292, '500 gm', 'C:\\Users\\Mahaj\\dsms\\good-life-almonds-500-g-0-20200901.jpg', 'GROCERY', 'almonds', 500),
('7598f2a1-6073-47c9-8497-e791e91652bf', 1619956673, 1619956673, 'camera tripod', 'C:\\Users\\Mahaj\\dsms\\camera stand.jpg', 'ELECTRONICS', 'tripod', 384),
('963ff16c-d143-4d22-aa48-6d0f3fe5a2b0', 1619954820, 1619954820, 'gold color', 'C:\\Users\\Mahaj\\dsms\\mens-printed-round-neck-t-shirt-gold-colour.jpg', 'GARMENTS', 'highlander tshirt', 410),
('b14000d1-2d87-422e-b5a5-7a600e486092', 1619954713, 1619954713, 'round neck faint brown', 'C:\\Users\\Mahaj\\dsms\\mens-printed-round-neck-t-shirt-faint brown colour.jpg', 'GARMENTS', 'hrx tshirt', 355),
('b620412b-e4c6-4765-83c4-ad0383189633', 1619956911, 1619956911, 'true bass earphones', 'C:\\Users\\Mahaj\\dsms\\earphones.jpg', 'ELECTRONICS', 'earphones', 499),
('ba3d2441-a0d1-4792-b8d7-ab9e8e68ce1f', 1619956873, 1619956873, '5 times rechargable ear buds', 'C:\\Users\\Mahaj\\dsms\\ear buds.jpg', 'ELECTRONICS', 'ear buds', 599),
('c71b3826-6ac6-4e1f-bf78-492a11a7ef5d', 1619957619, 1619957619, 'running shoes', 'C:\\Users\\Mahaj\\dsms\\61TSfjlL3tL._UL1100_.jpg', 'SHOES', 'nitro shoes', 600),
('d040fdec-276f-43f8-bec3-b8b5abfe2826', 1619954438, 1619954438, 'plane black shirt', 'C:\\Users\\Mahaj\\dsms\\mens-printed-round-neck shirt-black -colour.jpg', 'GARMENTS', 'roadster tshirt', 500),
('d687dfd3-3719-4229-8fa7-d5a7314fedd7', 1619954564, 1619954564, 'round neck full sleves black', 'C:\\Users\\Mahaj\\dsms\\mens-printed-round-neck-t-shirt-black with full sleves colour.jpg', 'GARMENTS', 'roadster tshirt', 345),
('da194d3e-0815-4f2a-bab8-e8d3d3f9a961', 1619956983, 1619956983, 'smooth keyboard', 'C:\\Users\\Mahaj\\dsms\\keyboard.jpg', 'ELECTRONICS', 'keyboard', 600),
('f6995a16-ccfb-4d18-8040-747a90a5e7dd', 1619956304, 1619956304, 'round neck purple color', 'C:\\Users\\Mahaj\\dsms\\mens-printed-round-neck-t-shirt-purple-colour.jpg', 'GARMENTS', 'sparks purple tshirt', 895);

-- --------------------------------------------------------

--
-- Table structure for table `order_entity`
--

CREATE TABLE `order_entity` (
  `id` varchar(255) NOT NULL,
  `created_at` bigint(20) NOT NULL,
  `updated_at` bigint(20) NOT NULL,
  `order_state` int(11) NOT NULL,
  `price` double NOT NULL,
  `shipping_address` text NOT NULL,
  `user_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_entity`
--

INSERT INTO `order_entity` (`id`, `created_at`, `updated_at`, `order_state`, `price`, `shipping_address`, `user_id`) VALUES
('664c36fb-e397-4d50-ad53-2ea32619007e', 1619955814, 1619955814, 0, 380, '', 'e1863146-dd48-4c84-896e-4d8a8f39c947'),
('6f31105f-c6e0-43f8-9bf5-026a85faddc5', 1619965334, 1619965334, 0, 500, '', 'e1863146-dd48-4c84-896e-4d8a8f39c947'),
('8ec17601-0055-4983-bf2c-457209b20823', 1619957839, 1619957839, 0, 500, '', '29a47dbd-af5a-4e5e-9aaf-df02a2e38485'),
('b0d3af65-d570-49fc-9e77-f5b7244a7c44', 1619957721, 1619957721, 0, 880, '', 'e1863146-dd48-4c84-896e-4d8a8f39c947');

-- --------------------------------------------------------

--
-- Table structure for table `order_item`
--

CREATE TABLE `order_item` (
  `id` varchar(255) NOT NULL,
  `created_at` bigint(20) NOT NULL,
  `updated_at` bigint(20) NOT NULL,
  `item_count` int(11) NOT NULL,
  `price` double NOT NULL,
  `item_id` varchar(255) NOT NULL,
  `order_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_item`
--

INSERT INTO `order_item` (`id`, `created_at`, `updated_at`, `item_count`, `price`, `item_id`, `order_id`) VALUES
('17f258ff-5f19-4402-a2ae-e1cdf393c5f9', 1619957721, 1619957721, 1, 380, '1784cdd3-ff51-4efc-95b5-9096d5b2e493', 'b0d3af65-d570-49fc-9e77-f5b7244a7c44'),
('8e21e1a6-b7c6-44c4-9e0a-0c0151e2cc3c', 1619965334, 1619965334, 1, 500, '07958fcb-6098-4e59-9286-f97957fce6d0', '6f31105f-c6e0-43f8-9bf5-026a85faddc5'),
('bd01691a-86c8-4f1f-bc51-e74e20b9f400', 1619957721, 1619957721, 1, 500, '07958fcb-6098-4e59-9286-f97957fce6d0', 'b0d3af65-d570-49fc-9e77-f5b7244a7c44'),
('d1e0b72a-e39e-402a-b3e6-0be14ef11c6d', 1619955814, 1619955814, 1, 380, '1784cdd3-ff51-4efc-95b5-9096d5b2e493', '664c36fb-e397-4d50-ad53-2ea32619007e'),
('d207a8f9-3523-4f69-ac5c-3dd8a45197ff', 1619957839, 1619957839, 1, 500, 'd040fdec-276f-43f8-bec3-b8b5abfe2826', '8ec17601-0055-4983-bf2c-457209b20823');

-- --------------------------------------------------------

--
-- Table structure for table `user_entity`
--

CREATE TABLE `user_entity` (
  `id` varchar(255) NOT NULL,
  `created_at` bigint(20) NOT NULL,
  `updated_at` bigint(20) NOT NULL,
  `address` text NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_entity`
--

INSERT INTO `user_entity` (`id`, `created_at`, `updated_at`, `address`, `email`, `first_name`, `last_name`, `password`, `user_type`) VALUES
('29a47dbd-af5a-4e5e-9aaf-df02a2e38485', 1619957786, 1619957786, 'nashik', 'testuser@gmail.com', 'test', 'user', 'test', 'CUSTOMER'),
('b99c1c65-0cf0-4374-941e-bfda1a975601', 1606660567, 1606660567, 'nashik', 'admin@gmail.com', 'admin_mayur', 'mahajan', 'test', 'ADMIN'),
('e1863146-dd48-4c84-896e-4d8a8f39c947', 1619955484, 1619955484, 'ashwin nagar nashik', 'mahajan.mayur26@gmail.com', 'mayur', 'mahajan', 'test', 'CUSTOMER');

-- --------------------------------------------------------

--
-- Table structure for table `wishlist_item`
--

CREATE TABLE `wishlist_item` (
  `id` varchar(255) NOT NULL,
  `created_at` bigint(20) NOT NULL,
  `updated_at` bigint(20) NOT NULL,
  `item_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `wishlist_item`
--

INSERT INTO `wishlist_item` (`id`, `created_at`, `updated_at`, `item_id`, `user_id`) VALUES
('9c5278b2-2841-4561-9c8c-3a95a9d0a74d', 1619957829, 1619957829, '1784cdd3-ff51-4efc-95b5-9096d5b2e493', '29a47dbd-af5a-4e5e-9aaf-df02a2e38485');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart_item`
--
ALTER TABLE `cart_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_cartItem_item_id` (`item_id`),
  ADD KEY `fk_cartItem_user_id` (`user_id`);

--
-- Indexes for table `item_entity`
--
ALTER TABLE `item_entity`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order_entity`
--
ALTER TABLE `order_entity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_order_user_id` (`user_id`);

--
-- Indexes for table `order_item`
--
ALTER TABLE `order_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_orderItem_item_id` (`item_id`),
  ADD KEY `fk_orderItem_orders_id` (`order_id`);

--
-- Indexes for table `user_entity`
--
ALTER TABLE `user_entity`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_4xad1enskw4j1t2866f7sodrx` (`email`);

--
-- Indexes for table `wishlist_item`
--
ALTER TABLE `wishlist_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_wishlist_item_id` (`item_id`),
  ADD KEY `fk_wishlist_user_id` (`user_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart_item`
--
ALTER TABLE `cart_item`
  ADD CONSTRAINT `fk_cartItem_item_id` FOREIGN KEY (`item_id`) REFERENCES `item_entity` (`id`),
  ADD CONSTRAINT `fk_cartItem_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_entity` (`id`);

--
-- Constraints for table `order_entity`
--
ALTER TABLE `order_entity`
  ADD CONSTRAINT `fk_order_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_entity` (`id`);

--
-- Constraints for table `order_item`
--
ALTER TABLE `order_item`
  ADD CONSTRAINT `fk_orderItem_item_id` FOREIGN KEY (`item_id`) REFERENCES `item_entity` (`id`),
  ADD CONSTRAINT `fk_orderItem_orders_id` FOREIGN KEY (`order_id`) REFERENCES `order_entity` (`id`);

--
-- Constraints for table `wishlist_item`
--
ALTER TABLE `wishlist_item`
  ADD CONSTRAINT `fk_wishlist_item_id` FOREIGN KEY (`item_id`) REFERENCES `item_entity` (`id`),
  ADD CONSTRAINT `fk_wishlist_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_entity` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
