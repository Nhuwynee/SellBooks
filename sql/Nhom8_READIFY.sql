-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3307
-- Thời gian đã tạo: Th12 05, 2024 lúc 07:42 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `readify4`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `book`
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
-- Đang đổ dữ liệu cho bảng `book`
--

INSERT INTO `book` (`idBook`, `title`, `author`, `category`, `imgResource`, `price`, `inStock`, `description`, `review`, `detailAuthor`, `pointOfBook`, `URLaudioBook`, `sampleRead`, `isActive`) VALUES
(1, 'Hồng Lục', 'Kim Diệp Tử', 'Tiểu thuyết', 'hongluc.jpg', 150000.00, 15, 'Hồng Lục là cuốn sách giúp độc giả nhận ra giá trị của những khoảnh khắc đơn giản và bình dị trong cuộc sống. Qua những câu chuyện và suy ngẫm sâu sắc, sách khuyến khích người đọc trân trọng từng hành động nhỏ, sống ý nghĩa hơn và lan tỏa yêu thương từ những việc tưởng chừng nhỏ nhặt nhất.', 'Hồng Lục cuốn hút người đọc nhờ sự giản dị và dễ áp dụng, truyền cảm hứng để sống tích cực và biết ơn những điều nhỏ bé quanh ta, từ đó tìm thấy niềm vui và ý nghĩa trong cuộc sống hàng ngày.', 'Kiêm Diệp Tử là tác giả nổi bật trong lĩnh vực phát triển bản thân, nổi tiếng với phong cách viết giản dị và sâu sắc. Trong Hồng Lục, cô khuyến khích độc giả trân trọng những điều bình dị và tìm niềm vui từ những khoảnh khắc nhỏ trong cuộc sống.', 8000, '', 'hongluc.docx', 1),
(2, 'Bạn Thật Sự Có Tài!', 'Tina Seelig', 'Self-help', 'banthatsucotai.jpg', 120000.00, 50, 'Khả năng sáng tạo không phải là một loại tài năng thiên bẩm chỉ dành cho một số người đặc biệt mà là một kỹ năng bất kỳ ai cũng có thể học hỏi. Tác giả, một chuyên gia và giáo sư tại Đại học Stanford, giúp độc giả hiểu đúng về bản chất của sự sáng tạo và chia sẻ nhiều ví dụ thực tế từ các công ty nổi tiếng như Google, Pixar, Facebook, IDEO…', 'Cuốn sách mang đến nhiều cảm hứng và góc nhìn mới về việc sáng tạo, hướng dẫn cách phát triển kỹ năng này thông qua các bước cụ thể. Độc giả đánh giá cao tính ứng dụng và thực tiễn trong cuộc sống cũng như công việc.', 'Tina Seelig là một chuyên gia trong lĩnh vực sáng tạo, giáo sư tại Stanford và tác giả của nhiều cuốn sách nổi tiếng về đổi mới tư duy.', 3000, 'banthatsucotaiaudiobook.mp3', 'banthatsucotai.docx', 1),
(3, 'Đi tìm lẽ sống', 'Viktor E. Frankl', 'Kỹ năng sống', 'ditimlesong.jpg', 90000.00, 25, 'Cuốn sách là hành trình sống còn của một nhà tâm lý học trong trại tập trung của Đức Quốc xã, đồng thời là tư tưởng của ông về ý nghĩa cuộc sống. Theo tác giả, ý nghĩa thực sự của cuộc sống đến từ sự vươn lên, khát vọng sống và vượt qua những khó khăn thử thách.', 'Cuốn sách gây xúc động mạnh và đã giúp hàng triệu độc giả tìm thấy động lực để sống mạnh mẽ hơn. Độc giả nhận định rằng tác phẩm chứa đựng giá trị nhân văn sâu sắc và rất thích hợp để đọc khi mất phương hướng.\r\n\r\n', 'Viktor E. Frankl là nhà tâm lý học người Áo nổi tiếng với liệu pháp “ý nghĩa”. Ông đã phát triển lý thuyết này sau những năm sống trong trại tập trung và trải qua nhiều thử thách về cả thể chất lẫn tinh thần.', 5000, 'ditimlesongaudiobook.mp3', 'ditimlesong.docx', 1),
(4, 'Dám nghĩ lớn', 'David J. Schwartz', 'Self-help', 'damnghilon.jpg', 130000.00, 70, '\"Dám Nghĩ Lớn\" khuyến khích độc giả phá bỏ các giới hạn trong suy nghĩ của bản thân, dám đặt ra những mục tiêu cao hơn và phấn đấu vì chúng. Cuốn sách hướng dẫn từng bước để phát triển tư duy tích cực và tự tin, giúp con người đạt được thành công.', 'Nhiều độc giả cho rằng đây là cuốn sách cần thiết cho những ai muốn vươn xa hơn trong sự nghiệp và cuộc sống. Tác giả giúp độc giả nhìn thấy cách suy nghĩ có thể thay đổi hoàn toàn hành vi và kết quả.', 'David J. Schwartz là nhà nghiên cứu và giảng viên nổi tiếng trong lĩnh vực phát triển cá nhân, được biết đến với những tác phẩm truyền cảm hứng cho hàng triệu người.', 2000, 'damnghilonaudiobook.mp3', 'damnghilon.docx', 1),
(5, 'Dám Làm Giàu', 'Phạm Thành Long', 'Self-help', 'damlamgiau.png', 200000.00, 10, 'Cuốn sách hướng dẫn những tư duy và chiến lược làm giàu, giúp độc giả dám nghĩ lớn, mạnh dạn đặt ra các mục tiêu về tài chính và tìm ra phương pháp để đạt được chúng.', 'Độc giả nhận xét rằng đây là một cuốn sách thực tế, có thể áp dụng để thay đổi tư duy về quản lý tài chính và xây dựng sự nghiệp. Nhiều người tìm thấy động lực để thực hiện ước mơ.', 'Phạm Thành Long là một diễn giả, doanh nhân nổi tiếng, truyền cảm hứng cho nhiều người trong lĩnh vực phát triển bản thân và làm giàu.', 3500, 'damlamgiauaudiobook.mp3', 'damlamgiau.docx', 1),
(6, 'Thức tỉnh mục đích sống', 'Eckhart Tolle', 'Kỹ năng sống\r\n', 'thuctinhmucdichsong.png', 175000.00, 100, 'Cuốn sách hướng dẫn cách sống hiện hữu và khám phá mục đích sống của bản thân. Eckhart Tolle giúp độc giả nhận ra giá trị của sự tĩnh lặng trong tâm hồn và tận hưởng từng khoảnh khắc.', 'Độc giả khen ngợi cuốn sách vì sự sâu sắc và thực tiễn trong việc khám phá ý nghĩa sống. Sách đã giúp nhiều người thay đổi cách nhìn về cuộc sống và tìm thấy sự bình an nội tại.', 'Eckhart Tolle là nhà văn, diễn giả nổi tiếng về chủ đề tâm linh và sống hiện hữu, với các tác phẩm truyền cảm hứng toàn cầu.', 4200, 'thuctinhmucdichsongaudiobook.mp3', 'thuctinhmucdichsong.docx', 1),
(7, 'Mình là cá việc của mình là bơi', 'Takeshi Furukawa', 'Self-help', 'minhlacavieccuaminhlaboi.jpg', 80000.00, 22, 'Cuốn sách truyền cảm hứng cho giới trẻ, giúp họ nhận ra tầm quan trọng của việc sống đúng với bản thân, không chạy theo kỳ vọng của người khác.', 'Sách được nhiều người yêu thích vì sự đơn giản nhưng sâu sắc, giúp người đọc suy nghĩ tích cực và có động lực vượt qua thử thách.', 'Takeshi Furukawa là một tác giả người Nhật chuyên viết sách về tâm lý và phát triển bản thân.', 2500, 'minhlacavieccuaminhlaboiaudiobook.mp3', 'minhlacavieccuaminhlaboi.docx', 1),
(8, 'Hạt giống yêu đời', 'Orison Swett Marden', 'Self-help', 'hatgiongyeudoi.jpg', 77000.00, 5, 'Cuốn sách chia sẻ những câu chuyện ý nghĩa, mang đến nguồn cảm hứng và động lực sống tích cực.', 'Độc giả nhận thấy cuốn sách giúp họ trân trọng cuộc sống và luôn nhìn nhận mọi khó khăn với góc nhìn tích cực.', 'Orison Swett Marden là một trong những tác giả truyền cảm hứng đầu tiên của Mỹ, người sáng lập phong trào New Thought.', 1500, 'hatgiongyeudoiaudiobook.mp3', 'hatgiongyeudoi.docx', 1),
(9, 'Thói quen thứ 8', 'Stephen R. Covey', 'Kỹ năng sống', 'thoiquenthu8.jpg', 220000.00, 12, 'Cuốn sách tiếp nối thành công của \"7 Thói Quen Hiệu Quả\", giúp độc giả tìm thấy tiếng nói nội tại và cách để phát huy tối đa tiềm năng của mình.', 'Nhiều độc giả đánh giá cao sự sâu sắc và hiệu quả của cuốn sách trong việc hướng dẫn phát triển bản thân và xây dựng sự nghiệp.', 'Stephen R. Covey là nhà giáo dục và tác giả của nhiều tác phẩm phát triển cá nhân nổi tiếng, giúp hàng triệu người đạt được thành công.', 3000, 'thoiquenthu8audiobook.mp3', 'thoiquenthu8.docx', 1),
(10, 'Điều vĩ đại đời thường', 'Robin Sharma', 'Self-help', 'dieuvidaidoithuong.jpg', 190000.00, 35, 'Cuốn sách giúp độc giả nhận ra giá trị của những điều bình dị trong cuộc sống, tạo động lực để đạt được những điều tuyệt vời từ những hành động nhỏ nhất.', 'Độc giả yêu thích vì sự giản dị và dễ áp dụng của cuốn sách, khuyến khích họ sống tích cực và biết ơn những điều nhỏ bé.', 'Robin Sharma là tác giả và nhà diễn thuyết nổi tiếng trong lĩnh vực phát triển cá nhân, với nhiều sách bán chạy toàn cầu.', 4000, 'dieuvidaidoithuongaudiobook.mp3', 'dieuvidaidoithuong.docx', 1),
(11, 'Bong bóng anh đào', 'Haruki Murakami', 'Tiểu thuyết', 'bongbonganhdao.jpg', 120000.00, 20, 'Bong Bóng Anh Đào là một tác phẩm đầy chất thơ của Haruki Murakami, kể về câu chuyện tình yêu ngắn ngủi nhưng mãnh liệt giữa hai nhân vật chính trong một mùa hoa anh đào nở rộ. Câu chuyện nhẹ nhàng và tràn đầy cảm xúc về sự lãng mạn và những gì còn lại sau một tình yêu không thành. Murakami khai thác chiều sâu tâm hồn và khao khát nội tâm của từng nhân vật, lột tả nỗi cô đơn và mộng mơ giữa cuộc sống hiện đại đầy ồn ào và xa cách.', 'Bong Bóng Anh Đào nhận được đánh giá cao về văn phong sâu sắc và trữ tình. Độc giả yêu thích cách mà Murakami xây dựng nhân vật và khung cảnh nên thơ, tạo ra một không gian huyền bí và cuốn hút.', 'Haruki Murakami là một nhà văn Nhật Bản nổi tiếng, chuyên viết về những câu chuyện siêu thực và sâu sắc, thường đề cập đến nỗi cô đơn và sự tìm kiếm ý nghĩa của con người trong cuộc sống hiện đại.', 4500, NULL, 'bongbonganhdao.docx', 1),
(12, 'Này! Chớ làm loạn', 'Linda Lê', 'Tiểu thuyết', 'naycholamloan.jpg', 135000.00, 2, 'Này! Chớ Làm Loạn là tác phẩm hài hước nhưng cũng đầy châm biếm về cuộc sống của một người phụ nữ trẻ giữa lòng thành phố náo nhiệt. Tác phẩm lột tả những suy nghĩ mâu thuẫn, trăn trở giữa những kỳ vọng của xã hội và mong muốn tự do cá nhân. Linda Lê đã khéo léo đan xen các tình tiết hài hước với những bài học ý nghĩa về cuộc sống hiện đại, khiến độc giả vừa cảm thấy thư giãn, vừa suy ngẫm sâu sắc.', 'Với văn phong dí dỏm và cách tiếp cận mới mẻ, Này! Chớ Làm Loạn nhận được sự yêu thích của độc giả, đặc biệt là những người trẻ tìm kiếm sự cân bằng giữa trách nhiệm và cuộc sống cá nhân.', 'Linda Lê là nhà văn nổi tiếng người Việt, tác phẩm của cô thường khai thác sâu sắc tâm lý và những trăn trở của con người trong xã hội hiện đại, với văn phong tự nhiên và đậm chất châm biếm.', 6000, NULL, 'naycholamloan.docx', 1),
(13, 'Một quả táo', 'Nguyễn Nhật Ánh', 'Tiểu thuyết', 'motquatao.jpg', 85000.00, 13, 'Một Quả Táo là một tác phẩm dành cho thiếu nhi, nhưng ý nghĩa của nó chạm đến mọi lứa tuổi. Câu chuyện xoay quanh cuộc sống của một cậu bé với ước mơ trở thành một người lớn và những kỳ vọng mà xã hội đặt lên vai cậu. Qua hình ảnh quả táo, tác giả gửi gắm thông điệp về sự trong sáng, hồn nhiên và giá trị của những điều giản dị trong cuộc sống. Câu chuyện không chỉ đơn thuần là hành trình tìm kiếm ước mơ mà còn là hành trình khám phá bản thân và tình yêu thương gia đình.', 'Độc giả ca ngợi tác phẩm vì cách viết giản dị nhưng sâu sắc. Nguyễn Nhật Ánh khéo léo khắc họa tâm tư, tình cảm của nhân vật, giúp người đọc cảm nhận được sự thuần khiết và ý nghĩa của tuổi trẻ. Cuốn sách như một bức tranh tươi sáng về những kỷ niệm ngọt ngào của tuổi thơ.', 'Nguyễn Nhật Ánh là một trong những tác giả nổi tiếng của văn học thiếu nhi Việt Nam. Ông được biết đến với những tác phẩm giàu cảm xúc, khắc họa chân thật cuộc sống và tâm tư của trẻ em, thường mang đến những thông điệp ý nghĩa về tình bạn, gia đình và ước mơ.', 2000, NULL, 'motquatao.docx', 1),
(14, 'Chí Phèo', 'Nam Cao', 'Văn học', 'chipheo.jpg', 75000.00, 20, 'Chí Phèo là một trong những tác phẩm nổi tiếng nhất của văn học hiện thực phê phán Việt Nam. Câu chuyện xoay quanh cuộc đời bi thảm của Chí Phèo, một người nông dân lương thiện trở thành kẻ côn đồ sau khi bị xã hội đẩy vào cùng đường. Tác phẩm thể hiện rõ nét những bất công, tủi nhục mà người nông dân phải chịu đựng dưới chế độ phong kiến, đồng thời phản ánh sâu sắc tâm trạng, nỗi cô đơn và khao khát tình yêu của Chí Phèo.', 'Tác phẩm được đánh giá cao về mặt nghệ thuật và giá trị nhân văn. Độc giả cảm nhận được sự đau đớn và bi kịch của nhân vật, cũng như sự tàn nhẫn của xã hội. Chí Phèo không chỉ là một tác phẩm văn học mà còn là một tác phẩm xã hội mang tính thời đại.', 'Nam Cao (tên thật là Trí Phương) là một trong những nhà văn lớn của văn học Việt Nam, nổi bật với phong cách hiện thực phê phán. Ông viết nhiều tác phẩm phản ánh cuộc sống của tầng lớp nông dân, thể hiện rõ những nỗi khổ và ước mơ của họ trong xã hội phong kiến.', 1500, NULL, 'chipheo.docx', 1),
(15, 'Làng nghề', 'Nguyễn Khắc Phê', 'Văn học', 'langnghe.jpg', 50000.00, 28, 'Làng Nghề là tác phẩm nổi bật trong thể loại văn học miêu tả cuộc sống của người dân quê hương Việt Nam. Tác phẩm không chỉ đơn thuần khắc họa hình ảnh những người thợ thủ công tài ba, mà còn phản ánh nét đẹp văn hóa truyền thống của làng quê Việt Nam. Qua những câu chuyện đời thường, tác giả thể hiện tình yêu quê hương, đất nước và những giá trị nhân văn cao đẹp.', 'Độc giả cảm nhận được sự gần gũi và chân thật trong từng câu chữ. Tác phẩm gợi nhớ về những kỷ niệm đẹp của tuổi thơ và tình yêu với làng quê, khiến người đọc không khỏi bồi hồi.', 'Nguyễn Khắc Phê là một nhà văn nổi tiếng trong văn học Việt Nam, được biết đến với những tác phẩm viết về nông thôn và cuộc sống của người dân. Ông thường khắc họa những giá trị văn hóa truyền thống, thể hiện tình yêu quê hương đất nước trong mỗi tác phẩm của mình.', 1300, NULL, 'langnghe.docx', 1),
(16, 'Vợ nhặt', 'Kim Lân', 'Văn học', 'vonhat.jpg', 65000.00, 50, 'Vợ Nhặt là một tác phẩm nổi tiếng của nhà văn Kim Lân, phản ánh cuộc sống khốn khổ của người nông dân trong thời kỳ đói kém sau Cách mạng tháng Tám. Câu chuyện xoay quanh nhân vật Tràng, một người nông dân nghèo, trong hoàn cảnh tuyệt vọng đã vô tình nhặt được vợ. Tác phẩm mang đậm giá trị nhân văn, thể hiện khát vọng sống và tình yêu thương giữa con người trong bối cảnh khó khăn.', 'Tác phẩm được độc giả đánh giá cao vì sự chân thực và sâu sắc. Kim Lân khéo léo lồng ghép giữa tình yêu và nỗi đau, giúp người đọc cảm nhận được cuộc sống bần hàn nhưng vẫn đầy ắp tình người.', 'Kim Lân là một trong những nhà văn tiêu biểu của văn học Việt Nam, nổi tiếng với những tác phẩm phản ánh cuộc sống và tâm tư của người nông dân. Ông có khả năng khắc họa chân thực những giá trị văn hóa và tâm hồn con người trong bối cảnh xã hội đầy biến động.', 2000, NULL, 'vonhat.docx', 1),
(17, 'Truyện Kiều', 'Nguyễn Du', 'Văn học', 'truyenkieu.jpg', 95000.00, 22, 'Truyện Kiều là một trong những tác phẩm vĩ đại nhất của văn học Việt Nam. Tác phẩm kể về cuộc đời đầy bi kịch của Kiều, một người con gái tài sắc nhưng gặp phải nhiều bất hạnh. Với những tình tiết cảm động, tác phẩm không chỉ phản ánh tâm tư của con người mà còn thể hiện sâu sắc những giá trị đạo đức và nhân văn.', 'Tác phẩm được ca ngợi không chỉ vì nội dung sâu sắc mà còn bởi hình thức nghệ thuật tinh tế. Nguyễn Du đã sử dụng ngôn ngữ thơ ca để khắc họa những hình ảnh, tâm trạng của nhân vật một cách sinh động.', 'Nguyễn Du là một trong những nhà thơ vĩ đại nhất của văn học cổ điển Việt Nam, nổi tiếng với khả năng sử dụng ngôn ngữ và hình ảnh để thể hiện tâm tư, tình cảm con người. Tác phẩm của ông thường mang giá trị nhân văn sâu sắc và phản ánh chân thực cuộc sống.', 2500, NULL, 'truyenkieu.docx', 1),
(18, 'Thao túng tâm lý', 'Robert Cialdini', 'Tâm lý học', 'thaotungtamly.jpg', 110000.00, 10, 'Thao Túng Tâm Lý là một cuốn sách nổi tiếng về tâm lý học và nghệ thuật thuyết phục. Tác giả Robert Cialdini đã phân tích các nguyên tắc thuyết phục trong giao tiếp và ứng xử xã hội. Qua đó, độc giả sẽ hiểu rõ hơn về cách mà tâm lý con người hoạt động và các kỹ thuật để gây ảnh hưởng đến người khác.', 'Cuốn sách được độc giả đánh giá cao vì tính ứng dụng thực tiễn và những nghiên cứu khoa học sâu sắc. Cialdini sử dụng nhiều ví dụ cụ thể và câu chuyện thú vị để minh họa cho các nguyên tắc mà ông đưa ra.', 'Robert Cialdini là một nhà tâm lý học nổi tiếng, được biết đến với các nghiên cứu về thuyết phục và ảnh hưởng. Ông là tác giả của nhiều cuốn sách best-seller, trong đó có Thao Túng Tâm Lý, cuốn sách đã trở thành tài liệu tham khảo không thể thiếu cho những ai quan tâm đến lĩnh vực này.', 3000, NULL, 'thaotungtamly.docx', 1),
(19, 'Sổ tay nhà thôi miên', 'Richard Nongard', 'Tâm lý học', 'sotaynhathoimien.jpg', 145000.00, 43, 'Sổ Tay Nhà Thôi Miên là một cuốn sách hữu ích cho những ai quan tâm đến thôi miên và sức mạnh của tâm trí. Richard Nongard, tác giả cuốn sách, đã chia sẻ những kiến thức, kỹ thuật và kinh nghiệm quý báu trong lĩnh vực thôi miên. Cuốn sách không chỉ dành cho những nhà thôi miên chuyên nghiệp mà còn cho bất kỳ ai muốn khám phá sức mạnh của tâm trí.', 'Cuốn sách nhận được nhiều đánh giá tích cực từ độc giả vì tính thực tiễn và dễ hiểu. Các kỹ thuật thôi miên trong sách được trình bày một cách chi tiết, dễ áp dụng.', 'Richard Nongard là một nhà thôi miên, diễn giả và tác giả nổi tiếng. Ông đã có nhiều năm kinh nghiệm trong lĩnh vực thôi miên và đào tạo. Tác phẩm của ông thường mang tính ứng dụng cao và tập trung vào việc phát triển kỹ năng cá nhân.', 4000, NULL, 'sotaynhathoimien.docx', 1),
(20, 'Phía sau nghi can X', 'Higashino Keigo', 'Trinh thám', 'phiasaunghicanx.jpg', 170000.00, 35, 'Phía Sau Nghi Can X là một tiểu thuyết trinh thám nổi tiếng của tác giả Higashino Keigo. Câu chuyện xoay quanh một vụ án giết người ly kỳ, nơi mà mọi nghi vấn đều đổ dồn về một người đàn ông có vẻ ngoài bình thường nhưng lại có khả năng phi thường. Tác phẩm không chỉ đơn thuần là một câu chuyện trinh thám mà còn sâu sắc khám phá tâm lý con người.', 'Cuốn sách nhận được sự yêu thích từ độc giả và được xem như một trong những tác phẩm trinh thám xuất sắc nhất. Higashino Keigo đã khéo léo xây dựng cốt truyện với nhiều bất ngờ, cùng những tình tiết hấp dẫn.', 'Higashino Keigo là một trong những tác giả trinh thám nổi tiếng nhất Nhật Bản. Ông được biết đến với khả năng xây dựng cốt truyện độc đáo và sâu sắc về tâm lý con người. Tác phẩm của ông thường chứa đựng những bất ngờ và những tình tiết ly kỳ.', 5000, NULL, 'phiasaunghicanx.docx', 1),
(21, 'Mật mã Da Vinci', 'Dan Brown', 'Trinh thám', 'matmadavinci.jpg', 132000.00, 45, 'Mật mã Da Vinci (The Da Vinci Code) là một tiểu thuyết ly kỳ của nhà văn Mỹ Dan Brown, xuất bản lần đầu năm 2003. Câu chuyện xoay quanh Robert Langdon, một giáo sư biểu tượng học nổi tiếng, và Sophie Neveu, một nhà mật mã học người Pháp. Họ cùng nhau điều tra cái chết bí ẩn của người quản lý bảo tàng Louvre – Jacques Saunière, đồng thời khám phá một chuỗi các mật mã và bí ẩn liên quan đến các tác phẩm nghệ thuật của Leonardo da Vinci.', 'Mật mã Da Vinci là một cuốn sách gây ấn tượng mạnh mẽ, đặc biệt với những ai đam mê lịch sử, tôn giáo và các thuyết âm mưu. Dan Brown đã khéo léo xây dựng một câu chuyện kịch tính xoay quanh các bí mật tôn giáo và nghệ thuật, kết hợp các tình tiết hồi hộp, căng thẳng với những khám phá mang tính biểu tượng.\r\n\r\nCốt truyện cuốn hút nhờ những bí ẩn phức tạp, liên quan đến Chén Thánh và các tác phẩm nghệ thuật của Leonardo da Vinci, khiến người đọc không ngừng tò mò về điều gì sẽ xảy ra tiếp theo. Cách Dan Brown khai thác các lý thuyết và kiến thức mật mã, các manh mối tinh vi, và những lời giải thích về lịch sử nghệ thuật là điểm đặc sắc của cuốn sách. Tuy nhiên, vì lối viết tập trung vào kịch tính và những lý giải gây tranh cãi, cuốn sách cũng gặp phải nhiều phản ứng trái chiều từ độc giả, đặc biệt là các tổ chức tôn giáo.\r\n\r\nDù có những ý kiến tranh cãi, Mật mã Da Vinci vẫn là một cuốn sách khó quên, đặt ra nhiều câu hỏi lớn và kích thích tư duy về niềm tin và sự thật trong lịch sử. Đây là một cuốn sách lý thú cho những ai yêu thích thể loại tiểu thuyết trinh thám pha lẫn yếu tố hư cấu và huyền bí, đồng thời mở ra những góc nhìn mới về mối liên hệ giữa khoa học, nghệ thuật và tín ngưỡng.', 'Dan Brown là một nhà văn Mỹ nổi tiếng với các tiểu thuyết ly kỳ về mật mã và bí ẩn tôn giáo. Sinh năm 1964, ông nổi bật với Mật mã Da Vinci, cuốn sách bán chạy toàn cầu và gây nhiều tranh cãi. Các tác phẩm của ông thường xoay quanh nhân vật Robert Langdon và kết hợp nghiên cứu lịch sử với những câu chuyện kịch tính, khám phá sâu sắc các bí mật cổ xưa. Với phong cách viết hấp dẫn, Dan Brown đã trở thành một trong những tác giả bán chạy nhất mọi thời đại.', 5000, NULL, 'matmadavinci.docx', 1),
(22, 'Vang bóng một thời', 'Nguyễn Tuân', 'Văn học', 'vangbongmotthoi.jpg', 75000.00, 88, '\"Vang Bóng Một Thời\" là một tác phẩm nổi bật của Nguyễn Tuân, tập trung vào những hình ảnh, phong vị và tinh thần của xã hội Việt Nam cổ truyền. Cuốn sách tái hiện vẻ đẹp tinh túy của những con người mang trong mình phẩm chất tài hoa, đạo đức và những nét đẹp văn hóa cổ xưa đang dần mai một. Qua từng câu chuyện, Nguyễn Tuân đã khắc họa sinh động, trân trọng những hình ảnh đẹp của một thời đã qua.', 'Tác phẩm này được độc giả yêu thích nhờ lối viết mượt mà, giàu hình ảnh và cảm xúc. \"Vang Bóng Một Thời\" như một bức tranh văn hóa thu nhỏ, gợi lại ký ức về những con người tài hoa, phong lưu của một thời xa xưa.', 'Nguyễn Tuân là một nhà văn Việt Nam tiêu biểu với lối viết phong phú, tài hoa, và đậm chất nghệ sĩ. Ông chuyên viết về con người và văn hóa Việt cổ, đề cao những giá trị truyền thống đang bị lãng quên giữa dòng chảy hiện đại hóa.', 3000, NULL, 'vangbongmotthoi.docx', 1),
(23, 'Sợi tóc', 'Thạch Lam', 'Văn học', 'soitoc.jpg', 65000.00, 100, '\"Sợi Tóc\" là một trong những tác phẩm đặc sắc của Thạch Lam, khắc họa cuộc sống của những con người bình dị với bao nỗi niềm khắc khoải, lãng mạn mà u buồn. Thạch Lam đã sử dụng hình ảnh chiếc \"sợi tóc\" để làm biểu tượng cho những khao khát, hy vọng mong manh, lắm khi mong manh đến khó nắm bắt. Tác phẩm diễn tả sự nhạy cảm trước những điều nhỏ nhặt nhưng sâu sắc trong cuộc sống, là một sự thức tỉnh về cái đẹp và ý nghĩa của những điều giản dị.', 'Độc giả yêu thích tác phẩm vì lối viết nhẹ nhàng, thấm đẫm tâm trạng. \"Sợi Tóc\" tạo cảm giác gần gũi, gợi lên sự đồng cảm sâu sắc với những khát khao và mâu thuẫn nội tâm của nhân vật, đồng thời để lại trong lòng người đọc một cảm giác sâu lắng, khó quên.', 'Thạch Lam là một nhà văn thuộc Tự Lực Văn Đoàn, nổi bật với phong cách viết tinh tế, gợi cảm và đầy nhân văn. Các tác phẩm của ông thường là những câu chuyện đời thường nhưng sâu sắc, tập trung vào những nỗi đau và khát vọng của con người. Thạch Lam có khả năng miêu tả tâm lý nhân vật một cách sinh động, đồng thời bộc lộ sự đồng cảm và chia sẻ với con người trong những hoàn cảnh khó khăn.', 4000, NULL, 'soitoc.docx', 1),
(24, 'Chân trời cũ', 'Hồ Dzếnh', 'Văn học', 'chantroicu.jpg', 93000.00, 20, '\"Chân Trời Cũ\" là tác phẩm tiêu biểu của Hồ Dzếnh, kể về cuộc sống và những suy tư của những người Việt Nam xa xứ trong thời kỳ đầu thế kỷ 20. Tác phẩm là lời tri ân quê hương, là sự khắc khoải và luyến tiếc về một nơi chốn đã xa, một chân trời cũ không thể quay lại. Qua ngòi bút tinh tế của Hồ Dzếnh, câu chuyện trở nên đậm chất thơ, thể hiện nỗi lòng của người tha hương và niềm đau đớn khi phải rời bỏ quê nhà.', 'Tác phẩm nhận được nhiều sự đồng cảm từ độc giả với lối kể chuyện thấm đẫm tình cảm, giàu hình ảnh. \"Chân Trời Cũ\" mang lại cho người đọc sự cảm thông sâu sắc với những ai đang sống xa quê, và để lại dư vị bâng khuâng về nỗi nhớ thương, hoài niệm.', 'Hồ Dzếnh là nhà văn mang trong mình hai dòng máu Việt - Hoa, vì vậy những tác phẩm của ông mang đậm nỗi niềm của một người luôn đi tìm kiếm quê hương. Hồ Dzếnh sở hữu giọng văn nhẹ nhàng, chất chứa nỗi buồn sâu lắng, dễ đi vào lòng người.', 3500, NULL, 'chantroicu.docx', 1),
(25, 'Dạo chơi, tuổi già', 'Sơn Nam', 'Văn học', 'daochoituoigia.jpg', 77000.00, 50, '\"Dạo Chơi, Tuổi Già\" là một trong những tác phẩm đầy chất phóng khoáng của Sơn Nam. Qua từng trang viết, ông đưa người đọc trở về với miền quê sông nước miền Nam Việt Nam, nơi chứa đựng những ký ức tuổi thơ và tuổi già, cũng như những triết lý sâu sắc về cuộc đời. Đây là một bức tranh đẹp về sự yên bình của đời sống làng quê và những giá trị giản dị trong cuộc sống, nhất là trong giai đoạn về già.', 'Độc giả đánh giá cao \"Dạo Chơi, Tuổi Già\" vì lối viết gần gũi, giản dị, nhưng đầy ý nghĩa. Cuốn sách mang đến những góc nhìn chân thực và sâu sắc về cuộc sống, giúp người đọc có cái nhìn lạc quan, phóng khoáng và thanh thản khi suy ngẫm về tuổi già.', 'Sơn Nam, tên thật là Phạm Minh Tày, là một nhà văn và nhà báo nổi tiếng của miền Nam Việt Nam, đặc biệt là vùng Nam Bộ. Ông sinh ra và lớn lên ở miền sông nước, và nhiều tác phẩm của ông phản ánh sâu sắc văn hóa, lối sống, và con người nơi đây.', 1500, NULL, 'daochoituoigia.docx', 1),
(26, 'Áo trắng', 'Nguyễn Văn Bổng', 'Tiểu thuyết', 'aotrang.jpg', 84000.00, 31, '\"Áo Trắng\" của Nguyễn Văn Bổng là câu chuyện về tình yêu, tuổi trẻ và những khát khao. Với bối cảnh là Việt Nam thời chiến tranh, tác phẩm khắc họa hình ảnh người phụ nữ Việt Nam duyên dáng, mạnh mẽ trong màu áo trắng, biểu tượng của sự trong sáng và niềm tin yêu vào tương lai. Những câu chuyện của \"Áo Trắng\" giúp người đọc nhận thấy sức sống mãnh liệt và sự lạc quan của con người, dù ở trong những hoàn cảnh khó khăn nhất.', '\"Áo Trắng\" được độc giả đón nhận nồng nhiệt, được xem như một lời nhắc nhở về tuổi thanh xuân và tình yêu quê hương. Qua lối viết chân thực và tinh tế, Nguyễn Văn Bổng đã truyền tải thành công những cảm xúc và hoài bão của người trẻ trong thời khắc khó khăn.', 'Nguyễn Văn Bổng là một nhà văn Việt Nam nổi tiếng với các tác phẩm văn học viết về chiến tranh, đất nước, và con người Việt Nam thời kỳ đấu tranh kháng chiến. Sinh ra và trưởng thành trong giai đoạn khó khăn của dân tộc, các tác phẩm của Nguyễn Văn Bổng phản ánh những hiện thực khắc nghiệt nhưng đầy tính nhân văn, với lối viết giàu hình ảnh và giàu cảm xúc.', 1000, NULL, 'aotrang.docx', 1),
(27, 'Chàng và em', 'Meggie Phạm', 'Tiểu thuyết', 'changvaem.jpg', 125000.00, 44, '\"Chàng Và Em\" là một câu chuyện tình yêu nhẹ nhàng và lãng mạn, xoay quanh những cung bậc cảm xúc từ ngọt ngào đến đau khổ của một cặp đôi trẻ. Cuốn sách như một bản nhạc tình yêu, nơi mỗi trang sách là một nốt nhạc, hòa quyện giữa niềm vui, sự hoài niệm, và nỗi buồn. Trong tình yêu này, cả chàng và em đều phải học cách trưởng thành, chấp nhận những khiếm khuyết của nhau và đối diện với thực tế không phải lúc nào cũng như mong muốn.', 'Độc giả nhận xét rằng \"Chàng Và Em\" đã chạm đến những góc khuất của tình yêu, khiến họ nhận ra vẻ đẹp và sức mạnh của tình yêu trong việc chữa lành tâm hồn. Cuốn sách không chỉ nói về tình yêu mà còn là sự trưởng thành của mỗi người trong tình yêu ấy.', 'Meggie Phạm là một tác giả trẻ chuyên viết về tình yêu và các mối quan hệ hiện đại. Với lối viết trong trẻo, chân thật và dễ tiếp cận, cô đã chinh phục độc giả trẻ tuổi nhờ khả năng tái hiện những cảm xúc tinh tế và sâu sắc của tình yêu. Tác phẩm của Meggie Phạm được yêu thích vì sự gần gũi, chân thành và dễ chạm đến trái tim người đọc.', 1400, NULL, 'changvaem.docx', 1),
(28, 'Bầu trời tình yêu', 'Mika', 'Tiểu thuyết', 'bautroitinhyeu.jpg', 110000.00, 10, '\"Bầu Trời Tình Yêu\" là một cuốn sách trữ tình, mang đậm triết lý về tình yêu và cuộc sống. Tác phẩm đưa người đọc đến với những câu chuyện nhỏ về các cặp đôi khác nhau, mỗi người một hoàn cảnh, một số phận, nhưng đều hướng về tình yêu như một niềm an ủi, một hy vọng giữa cuộc sống đầy biến động. Cuốn sách nhấn mạnh vào ý nghĩa của tình yêu đối với cuộc đời, như một bầu trời rộng lớn có thể bao dung tất cả những cảm xúc từ hạnh phúc đến khổ đau.', 'Độc giả yêu thích cuốn sách này vì cách mà tác giả truyền tải những thông điệp tích cực về tình yêu. Những câu chuyện tuy ngắn nhưng đậm tính nhân văn và cảm động, khiến người đọc không khỏi suy ngẫm về giá trị của tình yêu và lòng bao dung.', 'Mika là một tác giả nổi bật trong thể loại tiểu thuyết tình yêu, đặc biệt là các tác phẩm mang phong cách lãng mạn và đầy chất thơ. Với lối viết nhẹ nhàng, sâu sắc và đầy cảm xúc, Mika đã khắc họa được những cung bậc tình yêu một cách tinh tế và chân thực, chạm đến trái tim của người đọc qua từng trang sách.', 2300, NULL, 'bautroitinhyeu.docx', 1),
(29, 'Ngồi khóc trên cây', 'Nguyễn Nhật Ánh', 'Tiểu thuyết', 'ngoikhoctrencay.jpg', 95000.00, 10, '\"Ngồi Khóc Trên Cây\" là câu chuyện về tình yêu đầu đời, nhẹ nhàng và tinh khiết. Câu chuyện xoay quanh chàng trai tên Đông và mối tình trong sáng với một cô gái tên Rùa, người bạn đặc biệt từ thuở thơ ấu. Đó là tình yêu mang đầy sự kỳ diệu và những cảm xúc vụng dại của tuổi mới lớn. Cuốn sách đưa người đọc quay về với những kỷ niệm trong trẻo, những rung động đầu đời, và cả những nỗi buồn không thể giải thích của tuổi trẻ.', 'Độc giả nhận xét rằng \"Ngồi Khóc Trên Cây\" giống như một bức tranh về tuổi trẻ, vừa đẹp đẽ vừa có chút u buồn. Tác phẩm đã thành công khi gợi lại những cảm xúc trong sáng mà ai cũng từng trải qua, khiến người đọc không thể kìm nén được nụ cười và nước mắt.', 'Nguyễn Nhật Ánh là một trong những tác giả văn học nổi tiếng nhất Việt Nam, đặc biệt là trong thể loại văn học thiếu nhi và lãng mạn. Sinh năm 1955 tại Quảng Ngãi, Nguyễn Nhật Ánh được yêu mến không chỉ vì tài năng viết lách mà còn vì khả năng tạo ra những câu chuyện gần gũi, dễ hiểu nhưng lại chứa đựng những giá trị nhân văn sâu sắc. Các tác phẩm của ông luôn phản ánh những vấn đề của tuổi trẻ, tình bạn, tình yêu, và các mối quan hệ trong cuộc sống.', 4000, NULL, 'ngoikhoctrencay.docx', 1),
(30, 'Hoàng tử bé', 'Antoine de Saint-Exupéry', 'Tiểu thuyết', 'hoangtube.jpg', 100000.00, 25, '\"Hoàng Tử Bé\" là câu chuyện nổi tiếng về một cậu bé từ một hành tinh xa xôi, đến thăm Trái Đất và kết bạn với một phi công gặp nạn. Qua cuộc hành trình khám phá các hành tinh và gặp gỡ những nhân vật đặc biệt, Hoàng tử bé mang đến những bài học sâu sắc về tình bạn, tình yêu và những giá trị thực sự của cuộc sống. Cuốn sách được xem như một tác phẩm triết lý dành cho cả người lớn và trẻ em, với những thông điệp đầy ý nghĩa về tình cảm con người.', 'Độc giả trên toàn thế giới yêu thích \"Hoàng Tử Bé\" vì những bài học đơn giản nhưng sâu sắc mà nó truyền tải. Câu chuyện không chỉ là một cuốn sách thiếu nhi mà còn là một tác phẩm triết lý, giúp người đọc nhận ra vẻ đẹp của sự giản dị, tình bạn và lòng trắc ẩn.', 'Antoine de Saint-Exupéry (1900-1944) là một nhà văn và phi công người Pháp, nổi tiếng với tác phẩm \"Hoàng Tử Bé\" (tiếng Pháp: Le Petit Prince), một trong những cuốn sách thiếu nhi nổi tiếng nhất trên thế giới. Tuy nhiên, tác phẩm này không chỉ dành cho trẻ em mà còn chứa đựng nhiều thông điệp sâu sắc về cuộc sống, tình yêu và ý nghĩa của sự tồn tại.', 3000, NULL, 'hoangtube.docx', 1),
(31, 'Ba lần gặp gỡ', 'Tử Căng', 'Tiểu thuyết', 'balangapgo.jpg', 73000.00, 30, '\"Ba Lần Gặp Gỡ\" là một câu chuyện tình yêu về số phận, định mệnh và những mối tình bỏ lỡ. Câu chuyện kể về hai người gặp nhau trong ba thời điểm khác nhau của cuộc đời. Qua mỗi lần gặp gỡ, cả hai đều phải đối diện với những biến cố, những hiểu lầm, và cả những lựa chọn định mệnh. Tác phẩm làm nổi bật lên mối liên hệ giữa người với người trong cuộc sống, rằng những cuộc gặp gỡ, dù ngắn ngủi, đều có thể để lại dấu ấn sâu sắc trong trái tim.', 'Độc giả cho rằng \"Ba Lần Gặp Gỡ\" là một câu chuyện sâu sắc và nhiều cảm xúc. Câu chuyện khiến người đọc nhận ra rằng những cuộc gặp gỡ trong cuộc đời không bao giờ là tình cờ, và đôi khi những mối tình tưởng chừng lỡ dở lại mang đến cho con người những bài học quý giá về cuộc sống và tình yêu.', 'Tử Căng là một nhà văn trẻ nổi bật với phong cách viết đầy sâu sắc và lãng mạn. Anh thường viết về những câu chuyện tình yêu định mệnh, đan xen giữa niềm vui, nỗi buồn, và những khoảnh khắc lỡ làng, khiến người đọc không khỏi xúc động. Tử Căng có tài năng đặc biệt trong việc khắc họa những mối tình đẹp nhưng đầy thử thách, gợi lên sự đồng cảm sâu sắc từ độc giả. Với anh, mỗi cuộc gặp gỡ, dù ngắn ngủi hay kéo dài, đều có thể trở thành một dấu ấn quan trọng trong đời người.', 2000, NULL, 'balangapgo.docx', 1),
(33, 'Người truy tìm dấu vết', 'Tử Kim Thần', 'Trinh Thám', 'nguoitruytimdauvet.jpg', 250000.00, 12, 'Người truy tìm dấu vết là tiểu thuyết trinh thám nổi bật trong sự nghiệp của Tử Kim Trần, nhà văn nổi tiếng với những tác phẩm trinh thám hiện đại sắc sảo và giàu tính nhân văn. Câu chuyện xoay quanh một nhân vật điều tra tài tình với tư duy logic, khả năng phán đoán nhạy bén. Anh ta luôn kiên trì lần theo những dấu vết dù nhỏ nhặt nhất để lật mở những bí ẩn phức tạp và động cơ sâu xa của tội phạm.', 'Độc giả đánh giá cao tiểu thuyết của Tử Kim Trần vì cốt truyện đầy bất ngờ và cách xây dựng tâm lý nhân vật sâu sắc. Không chỉ dừng lại ở việc phá án, cuốn sách còn khai thác các yếu tố xã hội và mặt tối của con người. Văn phong của Tử Kim Trần sắc bén và trực diện, đưa người đọc từ hồi hộp này đến bất ngờ khác khi từng lớp bí mật được hé lộ. \"Người Truy Tìm Dấu Vết\" là một tác phẩm lôi cuốn với nhiều góc nhìn khác nhau, tạo nên bức tranh toàn cảnh về cuộc chiến giữa thiện và ác, lòng tham và sự phản bội.', 'Tử Kim Trần là một trong những tác giả trinh thám đương đại nổi bật của Trung Quốc. Ông có phong cách viết hiện đại, thực tế và thường xuyên kết hợp các yếu tố xã hội trong tác phẩm. Các tác phẩm của Tử Kim Trần không chỉ là truyện trinh thám mà còn là những bình luận sắc sảo về xã hội và đạo đức con người. Ông đã giành được nhiều sự yêu mến từ độc giả trong và ngoài nước, và một số tiểu thuyết của ông đã được chuyển thể thành phim và loạt phim truyền hình ăn khách.', 5000, NULL, 'nguoitruytimdauvet.docx', 1),
(34, 'Sherlock homes', 'Arthur Conan Doyle', 'Trinh thám', 'sherlockhomes.png', 175000.00, 22, 'Bộ truyện Sherlock Holmes gồm nhiều câu chuyện ngắn và tiểu thuyết, mô tả quá trình phá án của Holmes và người bạn đồng hành – bác sĩ John Watson. Holmes được mô tả là người có trí thông minh vượt trội, khả năng phân tích từng chi tiết dù là nhỏ nhất, và thường dùng phương pháp suy luận để giải mã các vụ án phức tạp. Các vụ án mà Holmes giải quyết trải dài từ những vụ mất tích, trộm cắp, cho đến những âm mưu và tội ác tinh vi. Qua mỗi câu chuyện, độc giả cảm nhận được tài năng đặc biệt và tính cách lập dị nhưng cuốn hút của Holmes.', 'Những câu chuyện về Sherlock Holmes không chỉ hấp dẫn ở các vụ án bí ẩn mà còn chứa đựng nhiều nét tinh tế về tâm lý nhân vật và xã hội Anh quốc thời kỳ Victoria. Sự tương phản giữa Holmes – một người lạnh lùng, ít bộc lộ cảm xúc và luôn tin vào lý trí, và Watson – người trung thành, giàu cảm xúc và thường ngưỡng mộ tài năng của Holmes, tạo nên sự cân bằng tuyệt vời. Những vụ án như \"A Study in Scarlet\" (Chiếc nhẫn tình cờ), \"The Hound of the Baskervilles\" (Con chó săn của dòng họ Baskerville) hay \"The Adventure of the Speckled Band\" (Dải băng lốm đốm) được đánh giá cao và trở thành kinh điển của thể loại trinh thám.', 'Arthur Conan Doyle (1859–1930) là một bác sĩ, nhà văn và nhà hoạt động người Anh. Doyle không chỉ nổi tiếng với bộ truyện Sherlock Holmes mà còn là tác giả của nhiều tác phẩm khác thuộc các thể loại viễn tưởng, lịch sử và phiêu lưu. Ông từng nhiều lần muốn dừng viết về Holmes để tập trung cho những tác phẩm khác, nhưng sự yêu mến của độc giả khiến ông tiếp tục sáng tác. Sự thành công của Holmes đã vượt xa mong đợi của Doyle, giúp ông trở thành một trong những tác giả nổi tiếng nhất thế giới, và Sherlock Holmes trở thành biểu tượng của sự thông minh, suy luận và công lý.\r\nDoyle đã để lại di sản văn học to lớn và ảnh hưởng sâu sắc đến thể loại truyện trinh thám hiện đại, là nguồn cảm hứng cho nhiều tác giả trinh thám sau này.\r\n', 2500, NULL, 'sherlockhomes.docx', 1),
(35, 'Án mạng mười một chữ', 'Keigo Higashino', 'Trinh thám', 'anmangmuoimotchu.jpg', 90000.00, 33, '“Án mạng Mười một chữ” là một tác phẩm trinh thám nổi tiếng của tác giả Keigo Higashino, một trong những tên tuổi lớn trong văn học trinh thám Nhật Bản. Câu chuyện xoay quanh vụ án giết người bí ẩn và những bí mật đen tối đằng sau đó. Mở đầu với một vụ giết người ở Tokyo, nạn nhân là một người đàn ông có mối liên hệ phức tạp với một nhóm người, mỗi người đều có những lý do riêng để muốn hại anh ta.\r\nĐiều đặc biệt trong cuốn sách này là bức thư của thủ phạm được gửi đến cảnh sát, với chỉ một câu: \"Kẻ giết người là một trong mười một người.\" Các nhân vật trong câu chuyện đều có mối liên kết với nhau, và qua từng chương, độc giả sẽ được dẫn dắt vào một mê cung phức tạp của các mối quan hệ và động cơ.\r\n', 'Cuốn sách này được nhiều độc giả yêu thích nhờ vào cách xây dựng nhân vật và cốt truyện đặc sắc. Keigo Higashino là một bậc thầy trong việc dẫn dắt câu chuyện theo cách đầy căng thẳng và giật gân, nhưng cũng rất tinh tế trong việc đưa ra những ẩn ý về xã hội và con người. Các tình tiết trong sách được xây dựng chặt chẽ, không có gì thừa, mỗi chi tiết nhỏ đều có lý do và vai trò riêng.\r\nĐiểm mạnh của cuốn sách không chỉ là việc giải quyết vụ án mà còn là sự phân tích sâu sắc tâm lý con người, cách họ đối diện với tội ác và hậu quả của những quyết định sai lầm. Cuốn sách này không chỉ là một câu chuyện về việc phá án, mà còn là một cuộc khảo sát về lương tâm, tội lỗi và sự chuộc tội.\r\n', 'Keigo Higashino là một nhà văn trinh thám nổi tiếng người Nhật, được biết đến rộng rãi với các tác phẩm mang tính suy luận sắc bén và câu chuyện đầy bí ẩn. Ông là tác giả của nhiều cuốn sách ăn khách, trong đó có “Sát Nhân Mười Một Chữ”, “Biến Hình” (The Miracles of the Namiya General Store), và “Câu Chuyện Cảnh Sát”. Tác phẩm của Higashino được biết đến với phong cách đặc trưng, kết hợp giữa trinh thám, tâm lý học và các yếu tố xã hội. Các tác phẩm của ông thường gây ấn tượng mạnh bởi sự phức tạp trong cốt truyện và những tình huống không thể đoán trước.\r\nKeigo Higashino đã nhận được nhiều giải thưởng văn học và được yêu mến không chỉ ở Nhật Bản mà còn trên toàn thế giới. Những câu chuyện của ông luôn mang lại cảm giác hồi hộp và trí tò mò cho độc giả, khiến họ không thể rời mắt khỏi trang sách cho đến khi bí ẩn cuối cùng được giải mã.\r\n', 1300, NULL, 'anmangmuoimotchu.docx', 1),
(40, 'Dư Sinh', 'Thu Nguyệt', 'Tiểu thuyết', 'toc_cua_toi.jpg', 147000.00, 100, 'Thu Nguyệt là tác giả ...', 'Dư Sinh là một cuốn sách hay', '', 3000, 'minhlacavieccuaminhlaboiaudiobook.mp3', 'vonhat.docx', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

CREATE TABLE `cart` (
  `idUser` int(11) NOT NULL,
  `idBook` int(11) NOT NULL,
  `number` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `cart`
--

INSERT INTO `cart` (`idUser`, `idBook`, `number`) VALUES
(2, 20, 1),
(5, 12, 1),
(5, 14, 1),
(6, 1, 1),
(6, 4, 1),
(6, 12, 1),
(7, 8, 5),
(9, 16, 1),
(19, 4, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `favouritebook`
--

CREATE TABLE `favouritebook` (
  `idUser` int(11) NOT NULL,
  `idBook` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `favouritebook`
--

INSERT INTO `favouritebook` (`idUser`, `idBook`) VALUES
(1, 9),
(2, 17),
(2, 30),
(3, 11),
(4, 3),
(5, 1),
(5, 12),
(5, 23),
(6, 25),
(7, 3),
(7, 5),
(7, 19),
(7, 22),
(7, 33),
(8, 26),
(9, 24),
(10, 21),
(19, 4),
(24, 22);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderitem`
--

CREATE TABLE `orderitem` (
  `idOrder` int(11) NOT NULL,
  `idBook` int(11) NOT NULL,
  `number` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `orderitem`
--

INSERT INTO `orderitem` (`idOrder`, `idBook`, `number`) VALUES
(1, 1, 1),
(1, 28, 1),
(2, 1, 2),
(2, 15, 1),
(3, 20, 1),
(4, 3, 3),
(4, 11, 1),
(4, 34, 1),
(5, 15, 1),
(5, 24, 2),
(6, 8, 1),
(6, 31, 2),
(7, 3, 2),
(7, 25, 1),
(8, 18, 1),
(8, 23, 1),
(9, 6, 3),
(9, 7, 5),
(9, 35, 1),
(10, 13, 1),
(24, 1, 2),
(26, 1, 1),
(26, 4, 1),
(26, 5, 1),
(27, 1, 1),
(27, 10, 1),
(29, 1, 1),
(29, 6, 1),
(30, 6, 1),
(30, 7, 1),
(31, 11, 1),
(32, 5, 1),
(32, 11, 1),
(33, 4, 1),
(34, 1, 1),
(35, 7, 1),
(36, 3, 1),
(37, 4, 1),
(38, 4, 1),
(39, 1, 1),
(40, 4, 1),
(41, 14, 1),
(42, 12, 1),
(43, 2, 1),
(43, 21, 1),
(44, 1, 1),
(44, 11, 1),
(45, 8, 1),
(46, 1, 1),
(47, 16, 1),
(48, 1, 2),
(48, 4, 3),
(49, 5, 1),
(50, 7, 1),
(50, 11, 1),
(50, 12, 1),
(51, 12, 1),
(51, 22, 3),
(52, 6, 1),
(53, 11, 2),
(53, 22, 4),
(54, 8, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `IdOrder` int(11) NOT NULL,
  `IdUser` int(11) DEFAULT NULL,
  `orderTime` datetime DEFAULT current_timestamp(),
  `pointOfOrder` decimal(10,2) DEFAULT NULL,
  `orderStatus` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`IdOrder`, `IdUser`, `orderTime`, `pointOfOrder`, `orderStatus`) VALUES
(1, 5, '2024-09-16 08:25:45', 2000.00, 'Đã giao'),
(2, 8, '2024-10-01 18:31:10', 1000.00, 'Đã huỷ'),
(3, 2, '2024-10-02 15:32:57', 5000.00, 'Đã giao'),
(4, 3, '2024-09-17 14:34:08', 500.00, 'Đã giao'),
(5, 4, '2024-09-24 20:00:53', 8700.00, 'Đã giao'),
(6, 3, '2024-09-30 13:35:28', 7000.00, 'Đã huỷ'),
(7, 3, '2024-10-06 18:36:04', 7000.00, 'Đang giao'),
(8, 2, '2024-10-13 12:36:45', 10000.00, 'Đã giao'),
(9, 10, '2024-10-22 16:20:38', 9000.00, 'Đã huỷ'),
(10, 9, '2024-10-03 10:10:08', 3000.00, 'Đã giao'),
(11, 7, '2024-09-09 12:56:26', 10000.00, 'Đã giao'),
(12, 5, '2024-11-12 12:57:14', 5000.00, 'Đã huỷ'),
(13, 4, '2024-11-03 13:57:51', 1000.00, 'Đang giao'),
(14, 6, '2024-11-01 16:58:31', 2000.00, 'Đã giao'),
(15, 9, '2024-11-10 11:59:36', 3000.00, 'Đã huỷ'),
(16, 10, '2024-09-16 19:00:22', 2000.00, 'Đã giao'),
(17, 5, '2024-10-17 18:00:50', 5000.00, 'Đã huỷ'),
(18, 2, '2024-11-12 13:01:30', 1000.00, 'Đã huỷ'),
(19, 4, '2024-11-03 09:01:53', 5000.00, 'Đã giao'),
(20, 7, '2024-09-23 17:02:30', 5000.00, 'Đang giao'),
(24, 1, '2024-11-27 05:16:25', 500.00, 'Đang giao'),
(26, 3, '2024-11-27 05:30:25', 6500.00, 'Đang giao'),
(27, 3, '2024-11-27 05:38:43', 6500.00, 'Đang giao'),
(29, 3, '2024-11-27 06:06:32', 1500.00, 'Đang giao'),
(30, 3, '2024-11-27 07:23:45', 2800.00, 'Đang giao'),
(31, 19, '2024-11-27 15:20:51', 1000.00, 'Đã giao'),
(32, 19, '2024-11-27 15:31:51', 5500.00, 'Đã giao'),
(33, 19, '2024-11-27 15:36:36', 2000.00, 'Đã giao'),
(34, 19, '2024-11-27 15:39:13', 8000.00, 'Đã giao'),
(35, 19, '2024-11-27 15:45:09', 2000.00, 'Đang giao'),
(36, 19, '2024-11-27 16:03:39', 500.00, 'Đang giao'),
(37, 19, '2024-11-27 16:04:50', 5000.00, 'Đang giao'),
(38, 19, '2024-11-27 16:05:40', 8000.00, 'Đã huỷ'),
(39, 19, '2024-11-27 16:18:42', 8000.00, 'Đã giao'),
(40, 19, '2024-11-27 16:33:37', 2000.00, 'Đã huỷ'),
(41, 19, '2024-11-27 16:42:06', 3000.00, 'Đang giao'),
(42, 19, '2024-11-27 16:42:47', 3500.00, 'Đang giao'),
(43, 19, '2024-12-04 06:25:47', NULL, 'Đã giao'),
(44, 19, '2024-12-04 06:36:02', 12500.00, 'Đã giao'),
(45, 19, '2024-12-04 06:37:37', 1500.00, 'Đang giao'),
(46, 19, '2024-12-04 07:00:24', 8000.00, 'Đang giao'),
(47, 19, '2024-12-04 07:03:38', 2000.00, 'Đang giao'),
(48, 3, '2024-12-04 08:33:34', 10000.00, 'Đang giao'),
(49, 3, '2024-12-04 08:34:26', 3500.00, 'Đã giao'),
(50, 24, '2024-12-05 07:01:59', 13000.00, 'Đang giao'),
(51, 3, '2024-12-05 07:08:03', 9000.00, 'Đang giao'),
(52, 3, '2024-12-05 07:08:33', 4200.00, 'Đang giao'),
(53, 3, '2024-12-05 07:31:32', 7500.00, 'Đang giao'),
(54, 3, '2024-12-05 07:32:00', 1500.00, 'Đang giao');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `IdUser` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `avatarImage` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT 1,
  `point` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`IdUser`, `password`, `name`, `phone`, `address`, `avatarImage`, `level`, `point`) VALUES
(1, '123123', 'Phạm Thị Thu Nguyệt', '0123456987', 'Hải Châu, Đà Nẵng', 'avatar_10.jpg', 1, 0),
(2, '212121', 'Nguyễn Thị Hiếu', '0387288212', 'Phú Ninh, Quảng Nam', 'avatar_1.jpg', 1, 0),
(3, '123456', 'Lưu Ngọc Yến Như', '09357382000', '123 Cù Chính Lan, Đà Nẵng', 'avatar_2.jpg', 2, 1500),
(4, '987654', 'Trần Thị Mai', '0987654321', '456 Lê Lợi, Đà Nẵng', 'avatar_3.jpg', 1, 0),
(5, '333333', 'Lê Văn Hòa', '0912345678', '789 Đinh Tiên Hoàng, Nha Trang', 'avatar_4.jpg', 2, 500),
(6, 'password', 'Phạm Thị Lan', '0345678910', '321 Lê Văn Sỹ, Cần Thơ', 'avatar_5.jpg', 2, 3000),
(7, 'abc123', 'Vũ Văn Bình', '0971234567', '654 Hùng Vương, Hải Phòng', 'avatar_6.jpg', 1, 0),
(8, 'hello123', 'Nguyễn Thị Hương', '0387654321', '987 Nguyễn Trãi, Vũng Tàu', 'avatar_7.jpg', 1, 0),
(9, 'mk123', 'Trần Văn Phúc', '0123987654', '159 Nguyễn Văn Cừ, Biên Hòa', 'avatar_8.jpg', 2, 2000),
(10, 'khongmk', 'Lê Thị Ngọc', '0918374650', '753 Lê Thánh Tôn, Đà Lạt', 'avatar_9.jpg', 1, 0),
(19, '000000', 'thunguyet', '0392163624', 'đà nẵng', 'avatar_10.jpg', 2, 2000),
(21, '000000', 'admin', '0392163624', 'Đà Nẵng', 'avatar_1.jpg', 1, 0),
(22, '123456', 'Phạm Nguyệt', '0258963741', '37 Trần Quang Khải, Hoài Nhơn, Bình Định', 'avatar_10.jpg', 2, 0),
(23, '000000', 'AdminThuNguyet', '0392163624', '07 đa mặn 6, ngũ hành sơn, đà nẵng', 'avatar_5.jpg', 1, 0),
(24, '147852369', 'thu nguyệt', '0392163628', '7 đa mặn 6, ngũ hành sơn, đà nẵng', 'avatar_10.jpg', 2, 13000),
(25, '123456', 'nhom88', '0789465128', '7 ngũ hành sơn, Đà Nẵng', 'avatar_10.jpg', 2, 0),
(26, 'nhom88', 'nhom8bansach', '0784159623', '7 ngũ hành sơn, đà nẵng', 'avatar_10.jpg', 2, 0),
(27, '123456789', 'nhom8detaibansach', '0852255852', '7 ngũ hành Sơn, Đà Nẵng', 'avatar_10.jpg', 2, 0),
(29, '147852', 'bansachnhom8', '0123123147', '7 ngũ hành Sơn, đà nẵng', 'avatar_10.jpg', 2, 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`idBook`);

--
-- Chỉ mục cho bảng `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`idUser`,`idBook`),
  ADD KEY `idBook` (`idBook`);

--
-- Chỉ mục cho bảng `favouritebook`
--
ALTER TABLE `favouritebook`
  ADD PRIMARY KEY (`idUser`,`idBook`),
  ADD KEY `idBook` (`idBook`);

--
-- Chỉ mục cho bảng `orderitem`
--
ALTER TABLE `orderitem`
  ADD PRIMARY KEY (`idOrder`,`idBook`),
  ADD KEY `idBook` (`idBook`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`IdOrder`),
  ADD KEY `IdUser` (`IdUser`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`IdUser`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `book`
--
ALTER TABLE `book`
  MODIFY `idBook` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `IdOrder` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `IdUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `users` (`IdUser`),
  ADD CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`idBook`) REFERENCES `book` (`idBook`);

--
-- Các ràng buộc cho bảng `favouritebook`
--
ALTER TABLE `favouritebook`
  ADD CONSTRAINT `favouritebook_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `users` (`IdUser`),
  ADD CONSTRAINT `favouritebook_ibfk_2` FOREIGN KEY (`idBook`) REFERENCES `book` (`idBook`);

--
-- Các ràng buộc cho bảng `orderitem`
--
ALTER TABLE `orderitem`
  ADD CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`idOrder`) REFERENCES `orders` (`IdOrder`),
  ADD CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`idBook`) REFERENCES `book` (`idBook`);

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`IdUser`) REFERENCES `users` (`IdUser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
