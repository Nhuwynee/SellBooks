-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 30, 2024 at 02:46 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `readify`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `idBook` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `imgResource` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `inStock` int(11) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `review` text DEFAULT NULL,
  `detailAuthor` text DEFAULT NULL,
  `pointOfBook` int(11) DEFAULT 2000,
  `URLaudioBook` varchar(255) DEFAULT NULL,
  `sampleRead` text DEFAULT NULL,
  `isActive` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`idBook`, `title`, `author`, `category`, `imgResource`, `price`, `inStock`, `description`, `review`, `detailAuthor`, `pointOfBook`, `URLaudioBook`, `sampleRead`, `isActive`) VALUES
(1, 'Hồng Lục', 'Kim Diệp Tử', 'Tiểu thuyết', 'hongluc.jpg', 150000.00, 15, 'Hồng Lục là cuốn sách giúp độc giả nhận ra giá trị của những khoảnh khắc đơn giản và bình dị trong cuộc sống. Qua những câu chuyện và suy ngẫm sâu sắc, sách khuyến khích người đọc trân trọng từng hành động nhỏ, sống ý nghĩa hơn và lan tỏa yêu thương từ những việc tưởng chừng nhỏ nhặt nhất.', 'Hồng Lục cuốn hút người đọc nhờ sự giản dị và dễ áp dụng, truyền cảm hứng để sống tích cực và biết ơn những điều nhỏ bé quanh ta, từ đó tìm thấy niềm vui và ý nghĩa trong cuộc sống hàng ngày.', 'Kiêm Diệp Tử là tác giả nổi bật trong lĩnh vực phát triển bản thân, nổi tiếng với phong cách viết giản dị và sâu sắc. Trong Hồng Lục, cô khuyến khích độc giả trân trọng những điều bình dị và tìm niềm vui từ những khoảnh khắc nhỏ trong cuộc sống.', 8000, 'nguoinamcham.mp3', 'hongluc.docx', 1),
(2, 'Bạn Thật Sự Có Tài!', 'Tina Seelig', 'Self-help', 'banthatsucotai.jpg', 120000.00, 50, 'Khả năng sáng tạo không phải là một loại tài năng thiên bẩm chỉ dành cho một số người đặc biệt mà là một kỹ năng bất kỳ ai cũng có thể học hỏi. Tác giả, một chuyên gia và giáo sư tại Đại học Stanford, giúp độc giả hiểu đúng về bản chất của sự sáng tạo và chia sẻ nhiều ví dụ thực tế từ các công ty nổi tiếng như Google, Pixar, Facebook, IDEO…', 'Cuốn sách mang đến nhiều cảm hứng và góc nhìn mới về việc sáng tạo, hướng dẫn cách phát triển kỹ năng này thông qua các bước cụ thể. Độc giả đánh giá cao tính ứng dụng và thực tiễn trong cuộc sống cũng như công việc.', 'Tina Seelig là một chuyên gia trong lĩnh vực sáng tạo, giáo sư tại Stanford và tác giả của nhiều cuốn sách nổi tiếng về đổi mới tư duy.', 3000, 'banthatsucotai.mp3', 'banthatsucotai.docx', 1),
(3, 'Đi tìm lẽ sống', 'Viktor E. Frankl', 'Tâm lý học', 'ditimlesong.jpg', 90000.00, 25, 'Cuốn sách là hành trình sống còn của một nhà tâm lý học trong trại tập trung của Đức Quốc xã, đồng thời là tư tưởng của ông về ý nghĩa cuộc sống. Theo tác giả, ý nghĩa thực sự của cuộc sống đến từ sự vươn lên, khát vọng sống và vượt qua những khó khăn thử thách.', 'Cuốn sách gây xúc động mạnh và đã giúp hàng triệu độc giả tìm thấy động lực để sống mạnh mẽ hơn. Độc giả nhận định rằng tác phẩm chứa đựng giá trị nhân văn sâu sắc và rất thích hợp để đọc khi mất phương hướng.\r\n\r\n', 'Viktor E. Frankl là nhà tâm lý học người Áo nổi tiếng với liệu pháp “ý nghĩa”. Ông đã phát triển lý thuyết này sau những năm sống trong trại tập trung và trải qua nhiều thử thách về cả thể chất lẫn tinh thần.', 5000, 'ditimlesong.mp3', 'ditimlesong.docx', 1),
(4, 'Dám nghĩ lớn', 'David J. Schwartz', 'Self-help', 'damnghilon.jpg', 130000.00, 70, '\"Dám Nghĩ Lớn\" khuyến khích độc giả phá bỏ các giới hạn trong suy nghĩ của bản thân, dám đặt ra những mục tiêu cao hơn và phấn đấu vì chúng. Cuốn sách hướng dẫn từng bước để phát triển tư duy tích cực và tự tin, giúp con người đạt được thành công.', 'Nhiều độc giả cho rằng đây là cuốn sách cần thiết cho những ai muốn vươn xa hơn trong sự nghiệp và cuộc sống. Tác giả giúp độc giả nhìn thấy cách suy nghĩ có thể thay đổi hoàn toàn hành vi và kết quả.', 'David J. Schwartz là nhà nghiên cứu và giảng viên nổi tiếng trong lĩnh vực phát triển cá nhân, được biết đến với những tác phẩm truyền cảm hứng cho hàng triệu người.', 2000, 'damnghilon.mp3', 'damnghilon.docx', 1),
(5, 'Dám Làm Giàu', 'Phạm Thành Long', 'Self-help', 'damlamgiau.png', 200000.00, 10, 'Cuốn sách hướng dẫn những tư duy và chiến lược làm giàu, giúp độc giả dám nghĩ lớn, mạnh dạn đặt ra các mục tiêu về tài chính và tìm ra phương pháp để đạt được chúng.', 'Độc giả nhận xét rằng đây là một cuốn sách thực tế, có thể áp dụng để thay đổi tư duy về quản lý tài chính và xây dựng sự nghiệp. Nhiều người tìm thấy động lực để thực hiện ước mơ.', 'Phạm Thành Long là một diễn giả, doanh nhân nổi tiếng, truyền cảm hứng cho nhiều người trong lĩnh vực phát triển bản thân và làm giàu.', 3500, 'damlamgiau.mp3', 'damlamgiau.docx', 1),
(6, 'Thức tỉnh mục đích sống', 'Eckhart Tolle', 'Tâm lý học', 'thuctinhmucdichsong.png', 175000.00, 100, 'Cuốn sách hướng dẫn cách sống hiện hữu và khám phá mục đích sống của bản thân. Eckhart Tolle giúp độc giả nhận ra giá trị của sự tĩnh lặng trong tâm hồn và tận hưởng từng khoảnh khắc.', 'Độc giả khen ngợi cuốn sách vì sự sâu sắc và thực tiễn trong việc khám phá ý nghĩa sống. Sách đã giúp nhiều người thay đổi cách nhìn về cuộc sống và tìm thấy sự bình an nội tại.', 'Eckhart Tolle là nhà văn, diễn giả nổi tiếng về chủ đề tâm linh và sống hiện hữu, với các tác phẩm truyền cảm hứng toàn cầu.', 4200, 'thuctinhmucdichsong.mp3', 'thuctinhmucdichsong.docx', 1),
(7, 'Mình là cá việc của mình là bơi', 'Takeshi Furukawa', 'Self-help', 'minhlacavieccuaminhlaboi.jpg', 80000.00, 22, 'Cuốn sách truyền cảm hứng cho giới trẻ, giúp họ nhận ra tầm quan trọng của việc sống đúng với bản thân, không chạy theo kỳ vọng của người khác.', 'Sách được nhiều người yêu thích vì sự đơn giản nhưng sâu sắc, giúp người đọc suy nghĩ tích cực và có động lực vượt qua thử thách.', 'Takeshi Furukawa là một tác giả người Nhật chuyên viết sách về tâm lý và phát triển bản thân.', 2500, 'minhlacavieccuaminhlaboi.mp3', 'minhlacavieccuaminhlaboi.docx', 1),
(8, 'Hạt giống yêu đời', 'Orison Swett Marden', 'Self-help', 'hatgiongyeudoi.jpg', 77000.00, 5, 'Cuốn sách chia sẻ những câu chuyện ý nghĩa, mang đến nguồn cảm hứng và động lực sống tích cực.', 'Độc giả nhận thấy cuốn sách giúp họ trân trọng cuộc sống và luôn nhìn nhận mọi khó khăn với góc nhìn tích cực.', 'Orison Swett Marden là một trong những tác giả truyền cảm hứng đầu tiên của Mỹ, người sáng lập phong trào New Thought.', 1500, 'hatgiongyeudoi.mp3', 'hatgiongyeudoi.docx', 1),
(9, 'Thói quen thứ 8', 'Stephen R. Covey', 'Kỹ năng sống', 'thoiquenthu8.jpg', 220000.00, 12, 'Cuốn sách tiếp nối thành công của \"7 Thói Quen Hiệu Quả\", giúp độc giả tìm thấy tiếng nói nội tại và cách để phát huy tối đa tiềm năng của mình.', 'Nhiều độc giả đánh giá cao sự sâu sắc và hiệu quả của cuốn sách trong việc hướng dẫn phát triển bản thân và xây dựng sự nghiệp.', 'Stephen R. Covey là nhà giáo dục và tác giả của nhiều tác phẩm phát triển cá nhân nổi tiếng, giúp hàng triệu người đạt được thành công.', 3000, 'thoiquenthu8.mp3', 'thoiquenthu8.docx', 1),
(10, 'Điều vĩ đại đời thường', 'Robin Sharma', 'Self-help', 'dieuvidaidoithuong.jpg', 190000.00, 35, 'Cuốn sách giúp độc giả nhận ra giá trị của những điều bình dị trong cuộc sống, tạo động lực để đạt được những điều tuyệt vời từ những hành động nhỏ nhất.', 'Độc giả yêu thích vì sự giản dị và dễ áp dụng của cuốn sách, khuyến khích họ sống tích cực và biết ơn những điều nhỏ bé.', 'Robin Sharma là tác giả và nhà diễn thuyết nổi tiếng trong lĩnh vực phát triển cá nhân, với nhiều sách bán chạy toàn cầu.', 4000, 'dieuvidaidoithuong.mp3', 'dieuvidaidoithuong.docx', 1),
(11, 'Bong bóng anh đào', 'Haruki Murakami', 'Tiểu thuyết', 'bongbonganhdao.jpg', 120000.00, 20, 'Bong Bóng Anh Đào là một tác phẩm đầy chất thơ của Haruki Murakami, kể về câu chuyện tình yêu ngắn ngủi nhưng mãnh liệt giữa hai nhân vật chính trong một mùa hoa anh đào nở rộ. Câu chuyện nhẹ nhàng và tràn đầy cảm xúc về sự lãng mạn và những gì còn lại sau một tình yêu không thành. Murakami khai thác chiều sâu tâm hồn và khao khát nội tâm của từng nhân vật, lột tả nỗi cô đơn và mộng mơ giữa cuộc sống hiện đại đầy ồn ào và xa cách.', 'Bong Bóng Anh Đào nhận được đánh giá cao về văn phong sâu sắc và trữ tình. Độc giả yêu thích cách mà Murakami xây dựng nhân vật và khung cảnh nên thơ, tạo ra một không gian huyền bí và cuốn hút.', 'Haruki Murakami là một nhà văn Nhật Bản nổi tiếng, chuyên viết về những câu chuyện siêu thực và sâu sắc, thường đề cập đến nỗi cô đơn và sự tìm kiếm ý nghĩa của con người trong cuộc sống hiện đại.', 4500, NULL, 'bongbonganhdao.docx', 1),
(12, 'Này!Chớ làm loạn', 'Linda Lê', 'Tiểu thuyết', 'naycholamloan.jpg', 135000.00, 2, 'Này! Chớ Làm Loạn là tác phẩm hài hước nhưng cũng đầy châm biếm về cuộc sống của một người phụ nữ trẻ giữa lòng thành phố náo nhiệt. Tác phẩm lột tả những suy nghĩ mâu thuẫn, trăn trở giữa những kỳ vọng của xã hội và mong muốn tự do cá nhân. Linda Lê đã khéo léo đan xen các tình tiết hài hước với những bài học ý nghĩa về cuộc sống hiện đại, khiến độc giả vừa cảm thấy thư giãn, vừa suy ngẫm sâu sắc.', 'Với văn phong dí dỏm và cách tiếp cận mới mẻ, Này! Chớ Làm Loạn nhận được sự yêu thích của độc giả, đặc biệt là những người trẻ tìm kiếm sự cân bằng giữa trách nhiệm và cuộc sống cá nhân.', 'Linda Lê là nhà văn nổi tiếng người Việt, tác phẩm của cô thường khai thác sâu sắc tâm lý và những trăn trở của con người trong xã hội hiện đại, với văn phong tự nhiên và đậm chất châm biếm.', 6000, NULL, 'naycholamloan.docx', 1),
(13, 'Một quả táo', 'Nguyễn Nhật Ánh', 'Tiểu thuyết', 'motquatao.jpg', 85000.00, 13, 'Một Quả Táo là một tác phẩm dành cho thiếu nhi, nhưng ý nghĩa của nó chạm đến mọi lứa tuổi. Câu chuyện xoay quanh cuộc sống của một cậu bé với ước mơ trở thành một người lớn và những kỳ vọng mà xã hội đặt lên vai cậu. Qua hình ảnh quả táo, tác giả gửi gắm thông điệp về sự trong sáng, hồn nhiên và giá trị của những điều giản dị trong cuộc sống. Câu chuyện không chỉ đơn thuần là hành trình tìm kiếm ước mơ mà còn là hành trình khám phá bản thân và tình yêu thương gia đình.', 'Độc giả ca ngợi tác phẩm vì cách viết giản dị nhưng sâu sắc. Nguyễn Nhật Ánh khéo léo khắc họa tâm tư, tình cảm của nhân vật, giúp người đọc cảm nhận được sự thuần khiết và ý nghĩa của tuổi trẻ. Cuốn sách như một bức tranh tươi sáng về những kỷ niệm ngọt ngào của tuổi thơ.', 'Nguyễn Nhật Ánh là một trong những tác giả nổi tiếng của văn học thiếu nhi Việt Nam. Ông được biết đến với những tác phẩm giàu cảm xúc, khắc họa chân thật cuộc sống và tâm tư của trẻ em, thường mang đến những thông điệp ý nghĩa về tình bạn, gia đình và ước mơ.', 2000, NULL, 'motquatao.docx', 1),
(14, 'Chí Phèo', 'Nam Cao', 'Văn học', 'chipheo.jpg', 75000.00, 20, 'Chí Phèo là một trong những tác phẩm nổi tiếng nhất của văn học hiện thực phê phán Việt Nam. Câu chuyện xoay quanh cuộc đời bi thảm của Chí Phèo, một người nông dân lương thiện trở thành kẻ côn đồ sau khi bị xã hội đẩy vào cùng đường. Tác phẩm thể hiện rõ nét những bất công, tủi nhục mà người nông dân phải chịu đựng dưới chế độ phong kiến, đồng thời phản ánh sâu sắc tâm trạng, nỗi cô đơn và khao khát tình yêu của Chí Phèo.', 'Tác phẩm được đánh giá cao về mặt nghệ thuật và giá trị nhân văn. Độc giả cảm nhận được sự đau đớn và bi kịch của nhân vật, cũng như sự tàn nhẫn của xã hội. Chí Phèo không chỉ là một tác phẩm văn học mà còn là một tác phẩm xã hội mang tính thời đại.', 'Nam Cao (tên thật là Trí Phương) là một trong những nhà văn lớn của văn học Việt Nam, nổi bật với phong cách hiện thực phê phán. Ông viết nhiều tác phẩm phản ánh cuộc sống của tầng lớp nông dân, thể hiện rõ những nỗi khổ và ước mơ của họ trong xã hội phong kiến.', 1500, NULL, 'chipheo.docx', 1),
(15, 'Làng nghề', 'Nguyễn Khắc Phê', 'Văn học', 'langnghe.jpg', 50000.00, 28, 'Làng Nghề là tác phẩm nổi bật trong thể loại văn học miêu tả cuộc sống của người dân quê hương Việt Nam. Tác phẩm không chỉ đơn thuần khắc họa hình ảnh những người thợ thủ công tài ba, mà còn phản ánh nét đẹp văn hóa truyền thống của làng quê Việt Nam. Qua những câu chuyện đời thường, tác giả thể hiện tình yêu quê hương, đất nước và những giá trị nhân văn cao đẹp.', 'Độc giả cảm nhận được sự gần gũi và chân thật trong từng câu chữ. Tác phẩm gợi nhớ về những kỷ niệm đẹp của tuổi thơ và tình yêu với làng quê, khiến người đọc không khỏi bồi hồi.', 'Nguyễn Khắc Phê là một nhà văn nổi tiếng trong văn học Việt Nam, được biết đến với những tác phẩm viết về nông thôn và cuộc sống của người dân. Ông thường khắc họa những giá trị văn hóa truyền thống, thể hiện tình yêu quê hương đất nước trong mỗi tác phẩm của mình.', 1300, NULL, 'langnghe.docx', 1),
(16, 'Vợ nhặt', 'Kim Lân', 'Văn học', 'vonhat.jpg', 65000.00, 50, 'Vợ Nhặt là một tác phẩm nổi tiếng của nhà văn Kim Lân, phản ánh cuộc sống khốn khổ của người nông dân trong thời kỳ đói kém sau Cách mạng tháng Tám. Câu chuyện xoay quanh nhân vật Tràng, một người nông dân nghèo, trong hoàn cảnh tuyệt vọng đã vô tình nhặt được vợ. Tác phẩm mang đậm giá trị nhân văn, thể hiện khát vọng sống và tình yêu thương giữa con người trong bối cảnh khó khăn.', 'Tác phẩm được độc giả đánh giá cao vì sự chân thực và sâu sắc. Kim Lân khéo léo lồng ghép giữa tình yêu và nỗi đau, giúp người đọc cảm nhận được cuộc sống bần hàn nhưng vẫn đầy ắp tình người.', 'Kim Lân là một trong những nhà văn tiêu biểu của văn học Việt Nam, nổi tiếng với những tác phẩm phản ánh cuộc sống và tâm tư của người nông dân. Ông có khả năng khắc họa chân thực những giá trị văn hóa và tâm hồn con người trong bối cảnh xã hội đầy biến động.', 2000, NULL, 'vonhat.docx', 1),
(17, 'Truyện Kiều', 'Nguyễn Du', 'Văn học', 'truyenkieu.jpg', 95000.00, 22, 'Truyện Kiều là một trong những tác phẩm vĩ đại nhất của văn học Việt Nam. Tác phẩm kể về cuộc đời đầy bi kịch của Kiều, một người con gái tài sắc nhưng gặp phải nhiều bất hạnh. Với những tình tiết cảm động, tác phẩm không chỉ phản ánh tâm tư của con người mà còn thể hiện sâu sắc những giá trị đạo đức và nhân văn.', 'Tác phẩm được ca ngợi không chỉ vì nội dung sâu sắc mà còn bởi hình thức nghệ thuật tinh tế. Nguyễn Du đã sử dụng ngôn ngữ thơ ca để khắc họa những hình ảnh, tâm trạng của nhân vật một cách sinh động.', 'Nguyễn Du là một trong những nhà thơ vĩ đại nhất của văn học cổ điển Việt Nam, nổi tiếng với khả năng sử dụng ngôn ngữ và hình ảnh để thể hiện tâm tư, tình cảm con người. Tác phẩm của ông thường mang giá trị nhân văn sâu sắc và phản ánh chân thực cuộc sống.', 2500, NULL, 'truyenkieu.docx', 1),
(18, 'Thao túng tâm lý', 'Robert Cialdini', 'Tâm lý học', 'thaotungtamly.jpg', 110000.00, 10, 'Thao Túng Tâm Lý là một cuốn sách nổi tiếng về tâm lý học và nghệ thuật thuyết phục. Tác giả Robert Cialdini đã phân tích các nguyên tắc thuyết phục trong giao tiếp và ứng xử xã hội. Qua đó, độc giả sẽ hiểu rõ hơn về cách mà tâm lý con người hoạt động và các kỹ thuật để gây ảnh hưởng đến người khác.', 'Cuốn sách được độc giả đánh giá cao vì tính ứng dụng thực tiễn và những nghiên cứu khoa học sâu sắc. Cialdini sử dụng nhiều ví dụ cụ thể và câu chuyện thú vị để minh họa cho các nguyên tắc mà ông đưa ra.', 'Robert Cialdini là một nhà tâm lý học nổi tiếng, được biết đến với các nghiên cứu về thuyết phục và ảnh hưởng. Ông là tác giả của nhiều cuốn sách best-seller, trong đó có Thao Túng Tâm Lý, cuốn sách đã trở thành tài liệu tham khảo không thể thiếu cho những ai quan tâm đến lĩnh vực này.', 3000, NULL, 'thaotungtamly.docx', 1),
(19, 'Sổ tay nhà thôi miên', 'Richard Nongard', 'Tâm lý học', 'sotaynhathoimien.jpg', 145000.00, 43, 'Sổ Tay Nhà Thôi Miên là một cuốn sách hữu ích cho những ai quan tâm đến thôi miên và sức mạnh của tâm trí. Richard Nongard, tác giả cuốn sách, đã chia sẻ những kiến thức, kỹ thuật và kinh nghiệm quý báu trong lĩnh vực thôi miên. Cuốn sách không chỉ dành cho những nhà thôi miên chuyên nghiệp mà còn cho bất kỳ ai muốn khám phá sức mạnh của tâm trí.', 'Cuốn sách nhận được nhiều đánh giá tích cực từ độc giả vì tính thực tiễn và dễ hiểu. Các kỹ thuật thôi miên trong sách được trình bày một cách chi tiết, dễ áp dụng.', 'Richard Nongard là một nhà thôi miên, diễn giả và tác giả nổi tiếng. Ông đã có nhiều năm kinh nghiệm trong lĩnh vực thôi miên và đào tạo. Tác phẩm của ông thường mang tính ứng dụng cao và tập trung vào việc phát triển kỹ năng cá nhân.', 4000, NULL, 'sotaynhathoimien.docx', 1),
(20, 'Phía sau nghi can X', 'Higashino Keigo', 'Trinh thám', 'phiasaunghicanX.jpg', 170000.00, 35, 'Phía Sau Nghi Can X là một tiểu thuyết trinh thám nổi tiếng của tác giả Higashino Keigo. Câu chuyện xoay quanh một vụ án giết người ly kỳ, nơi mà mọi nghi vấn đều đổ dồn về một người đàn ông có vẻ ngoài bình thường nhưng lại có khả năng phi thường. Tác phẩm không chỉ đơn thuần là một câu chuyện trinh thám mà còn sâu sắc khám phá tâm lý con người.', 'Cuốn sách nhận được sự yêu thích từ độc giả và được xem như một trong những tác phẩm trinh thám xuất sắc nhất. Higashino Keigo đã khéo léo xây dựng cốt truyện với nhiều bất ngờ, cùng những tình tiết hấp dẫn.', 'Higashino Keigo là một trong những tác giả trinh thám nổi tiếng nhất Nhật Bản. Ông được biết đến với khả năng xây dựng cốt truyện độc đáo và sâu sắc về tâm lý con người. Tác phẩm của ông thường chứa đựng những bất ngờ và những tình tiết ly kỳ.', 5000, NULL, 'phiasaunghicanX.docx', 1);

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `idUser` int(11) NOT NULL,
  `idBook` int(11) NOT NULL,
  `number` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`idUser`, `idBook`, `number`) VALUES
(2, 20, 1),
(3, 6, 2),
(5, 12, 1),
(5, 14, 1),
(6, 8, 2),
(7, 3, 3),
(7, 4, 5),
(7, 8, 5),
(9, 16, 1),
(10, 7, 3);

-- --------------------------------------------------------

--
-- Table structure for table `favouritebook`
--

CREATE TABLE `favouritebook` (
  `idUser` int(11) NOT NULL,
  `idBook` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `favouritebook`
--

INSERT INTO `favouritebook` (`idUser`, `idBook`) VALUES
(1, 9),
(2, 17),
(3, 2),
(3, 12),
(4, 3),
(5, 1),
(6, 19),
(7, 3),
(8, 4),
(9, 11);

-- --------------------------------------------------------

--
-- Table structure for table `orderitem`
--

CREATE TABLE `orderitem` (
  `idOrder` int(11) NOT NULL,
  `idBook` int(11) NOT NULL,
  `number` int(11) DEFAULT 1,
  `price` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orderitem`
--

INSERT INTO `orderitem` (`idOrder`, `idBook`, `number`, `price`) VALUES
(1, 1, 1, 142000.00),
(2, 1, 2, 284000.00),
(2, 15, 1, 48700.00),
(3, 20, 1, 165000.00),
(4, 3, 3, 255000.00),
(4, 11, 1, 115500.00),
(5, 15, 1, 48700.00),
(6, 8, 1, 77000.00),
(7, 3, 2, 177000.00),
(8, 18, 1, 110000.00),
(9, 6, 3, 512000.00),
(9, 7, 5, 387500.00),
(10, 13, 1, 83000.00);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `IdOrder` int(11) NOT NULL,
  `IdUser` int(11) DEFAULT NULL,
  `orderTime` datetime DEFAULT current_timestamp(),
  `orderCost` decimal(10,2) DEFAULT NULL,
  `orderStatus` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`IdOrder`, `IdUser`, `orderTime`, `orderCost`, `orderStatus`) VALUES
(1, 5, '2024-09-16 08:25:45', 142000.00, 'Đã giao'),
(2, 8, '2024-10-01 18:31:10', 771000.00, 'Đã huỷ'),
(3, 2, '2024-10-02 15:32:57', 165000.00, 'Đang giao'),
(4, 3, '2024-09-17 14:34:08', 370500.00, 'Đã giao'),
(5, 4, '2024-09-24 20:00:53', 48700.00, 'Đang giao'),
(6, 6, '2024-09-30 13:35:28', 77000.00, 'Đã huỷ'),
(7, 9, '2024-10-06 18:36:04', 177000.00, 'Đang giao'),
(8, 2, '2024-10-13 12:36:45', 110000.00, 'Đã giao'),
(9, 10, '2024-10-22 16:20:38', 899000.00, 'Đã huỷ'),
(10, 9, '2024-10-03 10:10:08', 83000.00, 'Đang giao');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `IdUser` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `avatarImage` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`IdUser`, `password`, `name`, `phone`, `address`, `avatarImage`, `level`) VALUES
(1, '123123', 'Phạm Thị Thu Nguyệt', '0123456987', 'Hải Châu, Đà Nẵng', 'avatar_10.jpg\r\n', 1),
(2, '212121', 'Nguyễn Thị Hiếu', '0387288212', 'Phú Ninh, Quảng Nam', 'avatar_1.jpg', 3),
(3, '123456', 'Lưu Ngọc Yến Như', '09357382711', '123 Cù Chính Lan, Đà Nẵng', 'avatar_2.jpg', 2),
(4, '987654', 'Trần Thị Mai', '0987654321', '456 Lê Lợi, Đà Nẵng', 'avatar_3.jpg\r\n', 1),
(5, '333333', 'Lê Văn Hòa', '0912345678', '789 Đinh Tiên Hoàng, Nha Trang', 'avatar_4.jpg', 3),
(6, 'password', 'Phạm Thị Lan', '0345678910', '321 Lê Văn Sỹ, Cần Thơ', 'avatar_5,jpg', 2),
(7, 'abc123', 'Vũ Văn Bình', '0971234567', '654 Hùng Vương, Hải Phòng', 'avatar_6.jpg', 1),
(8, 'hello123', 'Nguyễn Thị Hương', '0387654321', '987 Nguyễn Trãi, Vũng Tàu', 'avatar_7.jpg', 3),
(9, 'mk123', 'Trần Văn Phúc', '0123987654', '159 Nguyễn Văn Cừ, Biên Hòa', 'avatar_8.jpg', 2),
(10, 'khongmk', 'Lê Thị Ngọc', '0918374650', '753 Lê Thánh Tôn, Đà Lạt', 'avatar_9.jpg', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`idBook`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`idUser`,`idBook`),
  ADD KEY `idBook` (`idBook`);

--
-- Indexes for table `favouritebook`
--
ALTER TABLE `favouritebook`
  ADD PRIMARY KEY (`idUser`,`idBook`),
  ADD KEY `idBook` (`idBook`);

--
-- Indexes for table `orderitem`
--
ALTER TABLE `orderitem`
  ADD PRIMARY KEY (`idOrder`,`idBook`),
  ADD KEY `idBook` (`idBook`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`IdOrder`),
  ADD KEY `IdUser` (`IdUser`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`IdUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `idBook` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `IdOrder` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `IdUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `users` (`IdUser`),
  ADD CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`idBook`) REFERENCES `book` (`idBook`);

--
-- Constraints for table `favouritebook`
--
ALTER TABLE `favouritebook`
  ADD CONSTRAINT `favouritebook_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `users` (`IdUser`),
  ADD CONSTRAINT `favouritebook_ibfk_2` FOREIGN KEY (`idBook`) REFERENCES `book` (`idBook`);

--
-- Constraints for table `orderitem`
--
ALTER TABLE `orderitem`
  ADD CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`idOrder`) REFERENCES `orders` (`IdOrder`),
  ADD CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`idBook`) REFERENCES `book` (`idBook`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`IdUser`) REFERENCES `users` (`IdUser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
