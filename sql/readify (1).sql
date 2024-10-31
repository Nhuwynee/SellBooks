-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 30, 2024 at 02:09 PM
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
(1, 'Hồng Lục', 'Kim Diệp Tử', 'Tiểu thuyết', 'hongluc.jpg', 150000.00, 15, 'Hồng Lục là cuốn sách giúp độc giả nhận ra giá trị của những khoảnh khắc đơn giản và bình dị trong cuộc sống. Qua những câu chuyện và suy ngẫm sâu sắc, sách khuyến khích người đọc trân trọng từng hành động nhỏ, sống ý nghĩa hơn và lan tỏa yêu thương từ những việc tưởng chừng nhỏ nhặt nhất.', 'Hồng Lục cuốn hút người đọc nhờ sự giản dị và dễ áp dụng, truyền cảm hứng để sống tích cực và biết ơn những điều nhỏ bé quanh ta, từ đó tìm thấy niềm vui và ý nghĩa trong cuộc sống hàng ngày.', 'Kiêm Diệp Tử là tác giả nổi bật trong lĩnh vực phát triển bản thân, nổi tiếng với phong cách viết giản dị và sâu sắc. Trong Hồng Lục, cô khuyến khích độc giả trân trọng những điều bình dị và tìm niềm vui từ những khoảnh khắc nhỏ trong cuộc sống.', 8000, 'nguoinamcham.mp3', 'Trong cuộc sống hàng ngày, chúng ta thường chạy theo những mục tiêu lớn lao mà quên đi những điều giản dị xung quanh mình. Hãy dành một chút thời gian để dừng lại, hít thở và cảm nhận những khoảnh khắc nhỏ bé—một cánh hoa nở rộ, tiếng chim hót buổi sáng, hay nụ cười của người thân. Những điều này, tuy nhỏ nhưng lại có thể mang đến cho chúng ta niềm hạnh phúc vô tận.\r\n\r\nCuốn sách này không chỉ là một hành trình khám phá vẻ đẹp trong cuộc sống mà còn là lời nhắc nhở rằng hạnh phúc không nằm ở những điều lớn lao, mà chính là sự biết ơn đối với những gì ta đang có. Hãy sống chậm lại, yêu thương nhiều hơn, và nhận ra rằng mỗi ngày đều có điều kỳ diệu đang chờ đón bạn.', 1),
(2, 'Bạn Thật Sự Có Tài!', 'Tina Seelig', 'Self-help', 'banthatsucotai.jpg', 120000.00, 50, 'Khả năng sáng tạo không phải là một loại tài năng thiên bẩm chỉ dành cho một số người đặc biệt mà là một kỹ năng bất kỳ ai cũng có thể học hỏi. Tác giả, một chuyên gia và giáo sư tại Đại học Stanford, giúp độc giả hiểu đúng về bản chất của sự sáng tạo và chia sẻ nhiều ví dụ thực tế từ các công ty nổi tiếng như Google, Pixar, Facebook, IDEO…', 'Cuốn sách mang đến nhiều cảm hứng và góc nhìn mới về việc sáng tạo, hướng dẫn cách phát triển kỹ năng này thông qua các bước cụ thể. Độc giả đánh giá cao tính ứng dụng và thực tiễn trong cuộc sống cũng như công việc.', 'Tina Seelig là một chuyên gia trong lĩnh vực sáng tạo, giáo sư tại Stanford và tác giả của nhiều cuốn sách nổi tiếng về đổi mới tư duy.', 3000, 'banthatsucotai.mp3', '\"Sáng tạo không phải là một khả năng thiên bẩm. Nó cũng không phải là thứ chỉ xuất hiện khi chúng ta cần giải quyết các vấn đề lớn lao. Ngược lại, sáng tạo là kỹ năng mà bất kỳ ai cũng có thể học hỏi và phát triển. Nó là một hành trình gồm nhiều bước, nơi mà mỗi người phải tự thử nghiệm, thất bại, rồi lại bước tiếp. Sáng tạo nằm trong những chi tiết nhỏ bé nhất của cuộc sống hằng ngày, như việc chúng ta nấu ăn với các nguyên liệu hạn chế, tìm ra cách giải quyết khi công việc đột nhiên có sự thay đổi. Trong vai trò một người hướng dẫn sáng tạo, tôi đã chứng kiến rất nhiều lần mọi người bị mắc kẹt chỉ vì họ sợ thất bại hay sợ rằng ý tưởng của họ sẽ bị phê bình. Tuy nhiên, sáng tạo không thể nảy sinh từ sự sợ hãi. Để thực sự sáng tạo, chúng ta cần dũng cảm bước ra khỏi vùng an toàn, sẵn sàng thử nghiệm, và thậm chí thất bại nhiều lần trước khi thành công.\r\n\"Một trong những bài học đầu tiên tôi luôn dạy cho sinh viên của mình là phải học cách nhìn cuộc sống như một chuỗi những khả năng, nơi mà mọi thứ đều có thể mang lại một ý tưởng mới nếu ta nhìn với một góc nhìn mới mẻ. Sáng tạo là khả năng đặt câu hỏi, ‘Tại sao điều này lại như vậy?’ và ‘Nếu chúng ta làm điều đó khác đi thì sao?’ Trong các buổi học, tôi khuyến khích sinh viên không chỉ chấp nhận các ý tưởng sẵn có, mà phải tự đặt câu hỏi và thử thách chúng. Những công ty lớn như Google, Pixar, và IDEO nổi tiếng vì cách tiếp cận sáng tạo, không ngừng thách thức các quy tắc truyền thống và tìm kiếm các giải pháp đột phá. Mỗi khi bạn bắt đầu đặt câu hỏi, bạn đang thực hiện bước đầu tiên trong hành trình sáng tạo của mình.\"\r\n', 1),
(3, 'Đi tìm lẽ sống', 'Viktor E. Frankl', 'Tâm lý học', 'ditimlesong.jpg', 90000.00, 25, 'Cuốn sách là hành trình sống còn của một nhà tâm lý học trong trại tập trung của Đức Quốc xã, đồng thời là tư tưởng của ông về ý nghĩa cuộc sống. Theo tác giả, ý nghĩa thực sự của cuộc sống đến từ sự vươn lên, khát vọng sống và vượt qua những khó khăn thử thách.', 'Cuốn sách gây xúc động mạnh và đã giúp hàng triệu độc giả tìm thấy động lực để sống mạnh mẽ hơn. Độc giả nhận định rằng tác phẩm chứa đựng giá trị nhân văn sâu sắc và rất thích hợp để đọc khi mất phương hướng.\r\n\r\n', 'Viktor E. Frankl là nhà tâm lý học người Áo nổi tiếng với liệu pháp “ý nghĩa”. Ông đã phát triển lý thuyết này sau những năm sống trong trại tập trung và trải qua nhiều thử thách về cả thể chất lẫn tinh thần.', 5000, 'ditimlesong.mp3', '\"Nhiều người trong chúng ta thường nghĩ rằng hạnh phúc chỉ đến khi chúng ta đạt được một mục tiêu cụ thể nào đó. Chúng ta thường đặt ra những điều kiện cho niềm vui và ý nghĩa cuộc sống: chỉ khi có một công việc ổn định, một mối quan hệ hạnh phúc, hay thành công tài chính, chúng ta mới cảm thấy cuộc sống thật sự đáng giá. Nhưng điều tôi nhận ra sau thời gian sống trong trại tập trung của Đức Quốc xã là ý nghĩa cuộc sống không phụ thuộc vào hoàn cảnh bên ngoài, mà là sự tự do trong nội tâm của mỗi người.\r\n\"Khi bị giam cầm, tôi không còn gì ngoài niềm hy vọng mơ hồ rằng một ngày nào đó, tôi sẽ được tự do. Nhưng ngay cả trong những ngày đen tối nhất, tôi vẫn có sự lựa chọn: hoặc để nỗi sợ và sự tuyệt vọng xâm chiếm tâm trí, hoặc tập trung vào những suy nghĩ và cảm xúc mà tôi có thể kiểm soát. Cuộc sống thật đáng quý khi chúng ta tự tạo ra ý nghĩa của nó, ngay cả trong những điều kiện khắc nghiệt nhất. Khi bạn không còn gì ngoài tinh thần của mình, bạn sẽ nhận ra sức mạnh nội tại đó quan trọng hơn bất cứ tài sản nào. Đó là bài học quan trọng nhất mà cuộc đời đã dạy tôi – và cũng là điều tôi mong muốn chia sẻ đến tất cả mọi người.\"\r\n', 1),
(4, 'Dám nghĩ lớn', 'David J. Schwartz', 'Self-help', 'damnghilon.jpg', 130000.00, 70, '\"Dám Nghĩ Lớn\" khuyến khích độc giả phá bỏ các giới hạn trong suy nghĩ của bản thân, dám đặt ra những mục tiêu cao hơn và phấn đấu vì chúng. Cuốn sách hướng dẫn từng bước để phát triển tư duy tích cực và tự tin, giúp con người đạt được thành công.', 'Nhiều độc giả cho rằng đây là cuốn sách cần thiết cho những ai muốn vươn xa hơn trong sự nghiệp và cuộc sống. Tác giả giúp độc giả nhìn thấy cách suy nghĩ có thể thay đổi hoàn toàn hành vi và kết quả.', 'David J. Schwartz là nhà nghiên cứu và giảng viên nổi tiếng trong lĩnh vực phát triển cá nhân, được biết đến với những tác phẩm truyền cảm hứng cho hàng triệu người.', 2000, 'damnghilon.mp3', '\"Dám nghĩ lớn là một khái niệm đơn giản nhưng lại khó thực hiện đối với nhiều người, bởi vì từ nhỏ chúng ta đã được dạy dỗ để suy nghĩ thực tế, tránh mạo hiểm và giữ lấy những điều quen thuộc. Nhưng chính sự giới hạn trong tư duy đã kìm hãm thành công của chúng ta. Tôi đã gặp rất nhiều người có tiềm năng, nhưng họ không dám đặt ra các mục tiêu lớn vì sợ không đạt được. Dám nghĩ lớn không chỉ là về những giấc mơ, mà còn là niềm tin mạnh mẽ rằng bạn có thể thực hiện chúng nếu sẵn lòng thay đổi bản thân.\r\n\"Một trong những chìa khóa của tư duy dám nghĩ lớn là việc tin rằng mọi thành công đều bắt đầu từ trong tâm trí. Hãy hình dung chính mình trong vị trí bạn muốn đạt tới, hãy cảm nhận cảm giác khi bạn đã đạt được mục tiêu đó. Khi làm như vậy, tâm trí bạn sẽ dần chấp nhận và hỗ trợ mục tiêu đó như là điều có thể đạt được. Đây không phải là một bài tập tinh thần mơ hồ; khoa học đã chứng minh rằng khi chúng ta thực sự tin tưởng vào khả năng của mình, cơ thể và hành vi sẽ tự điều chỉnh để đạt được điều đó.\"\r\n', 1),
(5, 'Dám Làm Giàu', 'Phạm Thành Long', 'Self-help', 'damlamgiau.png', 200000.00, 10, 'Cuốn sách hướng dẫn những tư duy và chiến lược làm giàu, giúp độc giả dám nghĩ lớn, mạnh dạn đặt ra các mục tiêu về tài chính và tìm ra phương pháp để đạt được chúng.', 'Độc giả nhận xét rằng đây là một cuốn sách thực tế, có thể áp dụng để thay đổi tư duy về quản lý tài chính và xây dựng sự nghiệp. Nhiều người tìm thấy động lực để thực hiện ước mơ.', 'Phạm Thành Long là một diễn giả, doanh nhân nổi tiếng, truyền cảm hứng cho nhiều người trong lĩnh vực phát triển bản thân và làm giàu.', 3500, 'damlamgiau.mp3', '\"Làm giàu không phải là điều chỉ dành riêng cho một số người. Bất cứ ai có quyết tâm, kiên trì và chiến lược rõ ràng đều có thể đạt được sự giàu có mà họ mong muốn. Điều đầu tiên tôi khuyên độc giả khi bắt đầu hành trình làm giàu là phải đặt ra mục tiêu tài chính cụ thể và quyết tâm đạt được chúng. Bạn cần có một con số rõ ràng mà bạn muốn đạt được, và sau đó vạch ra một kế hoạch để tiến gần đến con số đó mỗi ngày. Tất cả những người giàu có đều có chung một đặc điểm là sự kiên định và sẵn sàng làm việc chăm chỉ.\r\n\"Hãy coi mỗi bước bạn đi là một viên gạch xây dựng cho tương lai. Làm giàu không chỉ là việc kiếm tiền mà còn là học cách quản lý và bảo vệ tài sản của bạn. Bạn cần có kế hoạch đầu tư khôn ngoan, học cách tiết kiệm và không ngừng trau dồi kiến thức về tài chính. Bất cứ khi nào bạn gặp khó khăn, hãy tự nhắc nhở rằng đó là một phần của hành trình và chính những khó khăn đó sẽ giúp bạn trưởng thành hơn.\"\r\n', 1),
(6, 'Thức tỉnh mục đích sống', 'Eckhart Tolle', 'Tâm lý học', 'thuctinhmucdichsong.png', 175000.00, 100, 'Cuốn sách hướng dẫn cách sống hiện hữu và khám phá mục đích sống của bản thân. Eckhart Tolle giúp độc giả nhận ra giá trị của sự tĩnh lặng trong tâm hồn và tận hưởng từng khoảnh khắc.', 'Độc giả khen ngợi cuốn sách vì sự sâu sắc và thực tiễn trong việc khám phá ý nghĩa sống. Sách đã giúp nhiều người thay đổi cách nhìn về cuộc sống và tìm thấy sự bình an nội tại.', 'Eckhart Tolle là nhà văn, diễn giả nổi tiếng về chủ đề tâm linh và sống hiện hữu, với các tác phẩm truyền cảm hứng toàn cầu.', 4200, 'thuctinhmucdichsong.mp3', '\"Mỗi người trong chúng ta đều có một mục đích sống riêng, nhưng đôi khi chúng ta bị cuốn vào guồng quay của cuộc sống mà quên mất ý nghĩa thực sự. Ý nghĩa cuộc sống không phải là những thành công bề ngoài mà xã hội thường đề cao, mà là sự kết nối với bản chất của chính mình. Bạn có bao giờ tự hỏi, nếu hôm nay là ngày cuối cùng của cuộc đời mình, bạn có hài lòng với những gì mình đã làm?\r\n\r\n\"Thức tỉnh mục đích sống không phải là thay đổi hoàn toàn cuộc đời ngay lập tức, mà là bắt đầu từ những điều nhỏ bé hàng ngày. Hãy dành thời gian để lắng nghe trái tim mình, khám phá những điều làm bạn thực sự hạnh phúc, và không ngừng học hỏi từ những trải nghiệm mới. Cuộc sống không phải là một cuộc đua mà là một hành trình. Khi bạn sống với mục đích, bạn sẽ cảm nhận được niềm vui sâu sắc hơn trong từng khoảnh khắc, và điều này sẽ mang lại cho bạn một nguồn sức mạnh nội tại.\"\r\n', 1),
(7, 'Mình là cá việc của mình là bơi', 'Takeshi Furukawa', 'Self-help', 'minhlacavieccuaminhlaboi.jpg', 80000.00, 22, 'Cuốn sách truyền cảm hứng cho giới trẻ, giúp họ nhận ra tầm quan trọng của việc sống đúng với bản thân, không chạy theo kỳ vọng của người khác.', 'Sách được nhiều người yêu thích vì sự đơn giản nhưng sâu sắc, giúp người đọc suy nghĩ tích cực và có động lực vượt qua thử thách.', 'Takeshi Furukawa là một tác giả người Nhật chuyên viết sách về tâm lý và phát triển bản thân.', 2500, 'minhlacavieccuaminhlaboi.mp3', '\"Cuộc sống giống như một đại dương rộng lớn và đầy thách thức. Khi nhìn vào mục tiêu cuối cùng, có thể bạn sẽ cảm thấy bị choáng ngợp. Nhưng hãy nghĩ mình là một con cá nhỏ bé, không ngừng bơi, vượt qua từng con sóng, không quan tâm đến những trở ngại. Điều quan trọng nhất là bạn phải luôn tiến về phía trước, không dừng lại vì khó khăn. Mỗi ngày là một cơ hội mới để học hỏi, trưởng thành và tiến gần hơn đến ước mơ của bạn.\r\n\"Khi đối mặt với khó khăn, hãy nhớ rằng đây chỉ là một phần của hành trình. Không có thành công nào mà không đi kèm với thử thách. Bạn không cần phải có tất cả câu trả lời ngay từ đầu, và đôi khi, chính những khó khăn sẽ giúp bạn trưởng thành và mạnh mẽ hơn. Hãy cứ bơi, dù cho mọi thứ có thể trở nên khó khăn. Cuối cùng, chỉ cần bạn tiếp tục nỗ lực, thành quả sẽ đến.\"\r\n', 1),
(8, 'Hạt giống yêu đời', 'Orison Swett Marden', 'Self-help', 'hatgiongyeudoi.jpg', 77000.00, 5, 'Cuốn sách chia sẻ những câu chuyện ý nghĩa, mang đến nguồn cảm hứng và động lực sống tích cực.', 'Độc giả nhận thấy cuốn sách giúp họ trân trọng cuộc sống và luôn nhìn nhận mọi khó khăn với góc nhìn tích cực.', 'Orison Swett Marden là một trong những tác giả truyền cảm hứng đầu tiên của Mỹ, người sáng lập phong trào New Thought.', 1500, 'hatgiongyeudoi.mp3', '\"Yêu đời là một nghệ thuật mà không phải ai cũng có thể dễ dàng nắm bắt. Thật đáng tiếc khi nhiều người để cho những gánh nặng cuộc sống đè nén niềm vui của họ. Tâm trạng của chúng ta giống như mảnh đất màu mỡ, nơi mà hạt giống của sự lạc quan và yêu đời có thể nảy mầm nếu chúng ta biết cách chăm sóc. Hạt giống yêu đời bắt đầu từ những điều nhỏ bé: một buổi sáng bình yên, một nụ cười, một cuộc trò chuyện chân thành, hay thậm chí là sự biết ơn với những điều giản dị nhất trong cuộc sống.\r\n\r\n\"Cuốn sách này khuyến khích bạn đón nhận mỗi ngày như một món quà, học cách yêu thương bản thân, và tìm ra cách vượt qua những khó khăn bằng thái độ tích cực. Bạn không thể kiểm soát mọi chuyện xảy ra trong cuộc sống, nhưng bạn hoàn toàn có thể chọn cách phản ứng trước chúng. Giữa những bộn bề và áp lực, hãy dành thời gian để lắng nghe chính mình, để hạt giống yêu đời trong bạn nảy mầm và lớn lên. Dù có trải qua bao nhiêu khó khăn, hãy nhớ rằng một trái tim yêu đời sẽ luôn là nền tảng vững chắc để bạn đối diện với mọi thử thách.\"\r\n', 1),
(9, 'Thói quen thứ 8', 'Stephen R. Covey', 'Kỹ năng sống', 'thoiquenthu8.jpg', 220000.00, 12, 'Cuốn sách tiếp nối thành công của \"7 Thói Quen Hiệu Quả\", giúp độc giả tìm thấy tiếng nói nội tại và cách để phát huy tối đa tiềm năng của mình.', 'Nhiều độc giả đánh giá cao sự sâu sắc và hiệu quả của cuốn sách trong việc hướng dẫn phát triển bản thân và xây dựng sự nghiệp.', 'Stephen R. Covey là nhà giáo dục và tác giả của nhiều tác phẩm phát triển cá nhân nổi tiếng, giúp hàng triệu người đạt được thành công.', 3000, 'thoiquenthu8.mp3', '\"Cuốn sách này tiếp tục khai phá và nâng cao những nguyên tắc trong ‘7 Thói Quen Hiệu Quả’ để giúp chúng ta đạt đến một tầm cao mới của sự thành công và ý nghĩa trong cuộc sống. Thói quen thứ 8 là khả năng ‘Tìm Ra Giọng Nói Của Chính Mình và Truyền Cảm Hứng Để Người Khác Tìm Ra Giọng Nói Của Họ.’ Điều này không chỉ đơn thuần là khả năng giao tiếp hay lãnh đạo, mà là một hành trình tìm kiếm ý nghĩa, sứ mệnh của mình trong thế giới. Giọng nói chính là sự kết nối giữa tài năng và đam mê của bạn, là cách bạn tạo ra sự khác biệt, làm phong phú thêm giá trị của mình.\r\n\"Tuy nhiên, để tìm ra giọng nói của mình, bạn cần nhìn nhận bản thân một cách sâu sắc và chân thật nhất. Hãy tự hỏi: Điều gì làm tôi cảm thấy mình đang sống trọn vẹn? Điều gì khiến tôi cảm thấy mình đang làm đúng? Không phải lúc nào cuộc sống cũng dễ dàng, nhưng khi bạn tìm thấy sứ mệnh của mình, bạn sẽ có đủ động lực để vượt qua khó khăn. Hãy nhớ rằng thành công thật sự không chỉ nằm ở những thành tựu bên ngoài mà còn ở khả năng giúp đỡ người khác tìm thấy tiếng nói của họ.\"\r\n', 1),
(10, 'Điều vĩ đại đời thường', 'Robin Sharma', 'Self-help', 'dieuvidaidoithuong.jpg', 190000.00, 35, 'Cuốn sách giúp độc giả nhận ra giá trị của những điều bình dị trong cuộc sống, tạo động lực để đạt được những điều tuyệt vời từ những hành động nhỏ nhất.', 'Độc giả yêu thích vì sự giản dị và dễ áp dụng của cuốn sách, khuyến khích họ sống tích cực và biết ơn những điều nhỏ bé.', 'Robin Sharma là tác giả và nhà diễn thuyết nổi tiếng trong lĩnh vực phát triển cá nhân, với nhiều sách bán chạy toàn cầu.', 4000, 'dieuvidaidoithuong.mp3', '\"Không phải những điều lớn lao hay phi thường mới là quan trọng, mà chính những hành động nhỏ bé hàng ngày mới là điều làm nên ý nghĩa của cuộc sống. Khi chúng ta yêu thương người khác, giúp đỡ một người bạn hay thậm chí chỉ là lắng nghe một người đang buồn, ta đang thực hiện những điều vĩ đại. Đừng bao giờ đánh giá thấp sức mạnh của những hành động bình thường mà bạn làm mỗi ngày – chính từ những điều nhỏ nhặt đó mà cuộc sống của bạn và những người xung quanh trở nên giàu ý nghĩa hơn.\r\n\r\n\"Điều vĩ đại đời thường còn là khi ta học cách trân trọng từng khoảnh khắc, hiểu rằng mỗi ngày đều là một cơ hội để mang lại niềm vui và sự ấm áp cho người khác. Đừng đợi đến khi có một lý do lớn lao mới cảm thấy cuộc sống ý nghĩa. Mỗi ngày, hãy hỏi bản thân: Mình có thể làm gì để cuộc sống của ai đó trở nên tốt hơn? Bởi lẽ, sự tử tế chân thành luôn tạo ra sức mạnh lan tỏa, và đó là điều vĩ đại nhất bạn có thể cống hiến cho thế giới.\"\r\n', 1),
(11, 'Bong bóng anh đào', 'Haruki Murakami', 'Tiểu thuyết', 'bongbonganhdao.jpg', 120000.00, 20, 'Bong Bóng Anh Đào là một tác phẩm đầy chất thơ của Haruki Murakami, kể về câu chuyện tình yêu ngắn ngủi nhưng mãnh liệt giữa hai nhân vật chính trong một mùa hoa anh đào nở rộ. Câu chuyện nhẹ nhàng và tràn đầy cảm xúc về sự lãng mạn và những gì còn lại sau một tình yêu không thành. Murakami khai thác chiều sâu tâm hồn và khao khát nội tâm của từng nhân vật, lột tả nỗi cô đơn và mộng mơ giữa cuộc sống hiện đại đầy ồn ào và xa cách.', 'Bong Bóng Anh Đào nhận được đánh giá cao về văn phong sâu sắc và trữ tình. Độc giả yêu thích cách mà Murakami xây dựng nhân vật và khung cảnh nên thơ, tạo ra một không gian huyền bí và cuốn hút.', 'Haruki Murakami là một nhà văn Nhật Bản nổi tiếng, chuyên viết về những câu chuyện siêu thực và sâu sắc, thường đề cập đến nỗi cô đơn và sự tìm kiếm ý nghĩa của con người trong cuộc sống hiện đại.', 4500, NULL, '\"Buổi sáng ấy, không gian ngập tràn sắc hoa anh đào. Cả một vùng trời như được phủ kín bởi màu hồng phớt mơ màng. Nhân vật chính, Yuki, ngồi một mình trên chiếc ghế gỗ cũ, nhìn xa xăm về phía những cánh hoa nhẹ nhàng rơi xuống mặt đất. \'Còn gì đẹp hơn khoảnh khắc này?\' - cô tự hỏi mình, cảm thấy lòng mình như được trút hết mọi gánh nặng.\r\nTrong khoảnh khắc ngắn ngủi ấy, Yuki gặp Takashi, một chàng trai lạ mặt với nụ cười hiền và ánh mắt đầy bí ẩn. Hai người nhanh chóng trở nên thân thiết, chia sẻ những câu chuyện đời thường nhưng sâu sắc. Họ cùng nhau lang thang dưới tán hoa, trò chuyện về những ước mơ còn dang dở và những nỗi đau không thể gọi tên. \'Anh có tin rằng chúng ta có thể gặp lại nhau mãi mãi không?\' - Yuki thì thầm, không biết rằng lời nói ấy sẽ là dấu chấm hết cho mối tình thoáng qua.\r\nKhi mùa hoa tàn, cả hai rời xa nhau, nhưng những kỷ niệm giữa họ vẫn mãi là bong bóng ký ức mong manh, đẹp đẽ. Mùa hoa tiếp theo sẽ đến, nhưng liệu có còn những cánh hoa đẹp như ngày ấy? Có lẽ, trong ký ức của họ, những bong bóng anh đào sẽ mãi bay trong gió, trong tiếng thở dài của những kẻ đã từng yêu nhau.\"\r\n', 1),
(12, 'Này!Chớ làm loạn', 'Linda Lê', 'Tiểu thuyết', 'naycholamloan.jpg', 135000.00, 2, 'Này! Chớ Làm Loạn là tác phẩm hài hước nhưng cũng đầy châm biếm về cuộc sống của một người phụ nữ trẻ giữa lòng thành phố náo nhiệt. Tác phẩm lột tả những suy nghĩ mâu thuẫn, trăn trở giữa những kỳ vọng của xã hội và mong muốn tự do cá nhân. Linda Lê đã khéo léo đan xen các tình tiết hài hước với những bài học ý nghĩa về cuộc sống hiện đại, khiến độc giả vừa cảm thấy thư giãn, vừa suy ngẫm sâu sắc.', 'Với văn phong dí dỏm và cách tiếp cận mới mẻ, Này! Chớ Làm Loạn nhận được sự yêu thích của độc giả, đặc biệt là những người trẻ tìm kiếm sự cân bằng giữa trách nhiệm và cuộc sống cá nhân.', 'Linda Lê là nhà văn nổi tiếng người Việt, tác phẩm của cô thường khai thác sâu sắc tâm lý và những trăn trở của con người trong xã hội hiện đại, với văn phong tự nhiên và đậm chất châm biếm.', 6000, NULL, '): \"Trong thế giới mà mọi thứ đều dường như được quy định sẵn, cô gái trẻ Linh cảm thấy mình như một kẻ lạc lõng. Sáng đi làm, chiều về nhà, cuộc sống cứ xoay quanh công việc và những áp lực mà cô không bao giờ hiểu hết. \'Tại sao chúng ta cứ phải sống theo khuôn khổ như thế?\' - Linh tự hỏi mình, khi đứng trước một cột đèn giao thông, chờ đèn đỏ tắt để băng qua đường. Những câu hỏi ấy dần trở thành một phần trong đời cô, một phần của cuộc sống mà Linh khao khát thay đổi nhưng chưa bao giờ đủ can đảm thực hiện.\r\nMột ngày nọ, khi mọi thứ bỗng chốc trở nên tồi tệ hơn, Linh quyết định sẽ \'nổi loạn\' - cô sẽ làm những điều mà trước đây mình chưa bao giờ nghĩ đến. Linh bắt đầu phá vỡ những thói quen hằng ngày, khám phá những góc phố mới, và gặp gỡ những người bạn mới. Mỗi cuộc gặp gỡ, mỗi trải nghiệm là một bài học, là cách để cô cảm nhận cuộc sống theo cách của riêng mình.\r\nKhi nhìn lại, Linh nhận ra rằng chính những lần \'làm loạn\' ấy đã giúp cô tìm thấy phiên bản tốt hơn của mình, không hoàn hảo nhưng tự do và hạnh phúc hơn bao giờ hết.\"\r\n', 1),
(13, 'Một quả táo', 'Nguyễn Nhật Ánh', 'Tiểu thuyết', 'motquatao.jpg', 85000.00, 13, 'Một Quả Táo là một tác phẩm dành cho thiếu nhi, nhưng ý nghĩa của nó chạm đến mọi lứa tuổi. Câu chuyện xoay quanh cuộc sống của một cậu bé với ước mơ trở thành một người lớn và những kỳ vọng mà xã hội đặt lên vai cậu. Qua hình ảnh quả táo, tác giả gửi gắm thông điệp về sự trong sáng, hồn nhiên và giá trị của những điều giản dị trong cuộc sống. Câu chuyện không chỉ đơn thuần là hành trình tìm kiếm ước mơ mà còn là hành trình khám phá bản thân và tình yêu thương gia đình.', 'Độc giả ca ngợi tác phẩm vì cách viết giản dị nhưng sâu sắc. Nguyễn Nhật Ánh khéo léo khắc họa tâm tư, tình cảm của nhân vật, giúp người đọc cảm nhận được sự thuần khiết và ý nghĩa của tuổi trẻ. Cuốn sách như một bức tranh tươi sáng về những kỷ niệm ngọt ngào của tuổi thơ.', 'Nguyễn Nhật Ánh là một trong những tác giả nổi tiếng của văn học thiếu nhi Việt Nam. Ông được biết đến với những tác phẩm giàu cảm xúc, khắc họa chân thật cuộc sống và tâm tư của trẻ em, thường mang đến những thông điệp ý nghĩa về tình bạn, gia đình và ước mơ.', 2000, NULL, '\"Trong một ngôi làng nhỏ, có một cậu bé tên là Tùng. Tùng là một cậu bé vui tính, hồn nhiên và đặc biệt yêu thích quả táo. Cậu thường chạy ra vườn mỗi sáng, nơi có những cây táo sai trĩu quả. Mỗi lần cậu thấy những quả táo chín đỏ, ánh nắng mặt trời chiếu rọi lên chúng, cậu lại cảm thấy một niềm khao khát mãnh liệt. \'Một ngày nào đó, mình sẽ có một quả táo cho riêng mình!\' - cậu thầm nghĩ.\r\nHàng ngày, Tùng chăm sóc cho cây táo trong vườn, tưới nước và vun xới đất. Cậu muốn cây táo phát triển thật tốt để cho ra những quả táo ngon nhất. Mỗi buổi chiều, cậu lại đứng dưới gốc cây, nhìn ngắm những quả táo, mơ về ngày chúng chín mọng. Một hôm, Tùng quyết định tổ chức một buổi lễ để ăn mừng ngày quả táo đầu tiên của mình chín. Cậu mời tất cả bạn bè và người thân trong làng đến tham dự. Mọi người đều háo hức chờ đợi.\r\nKhi ngày đó đến, Tùng rất hồi hộp. Cậu đã chuẩn bị mọi thứ thật chu đáo. Tuy nhiên, khi mọi người đến, cậu phát hiện ra rằng quả táo mình chăm sóc vẫn chưa chín. Thời gian trôi qua, mọi người dần cảm thấy chán nản. Tùng cảm thấy nản lòng nhưng vẫn không từ bỏ. Cậu nhớ lại những kỷ niệm đẹp khi chăm sóc cây táo, những buổi chiều vui vẻ bên bạn bè. Cậu tự nhủ: \'Chỉ cần mình kiên nhẫn, mọi thứ sẽ đến thôi!\'\r\nCuối cùng, một buổi sáng, Tùng phát hiện ra quả táo đã chín! Nó to, tròn, và đỏ rực rỡ dưới ánh nắng mặt trời. Cậu không thể kìm được sự vui mừng, chạy ra vườn, gọi mọi người đến. Khi mọi người cùng nhau thưởng thức quả táo, Tùng hiểu rằng sự chờ đợi và nỗ lực của mình đã được đền đáp. Hạnh phúc không chỉ nằm ở việc có được quả táo, mà còn ở những kỷ niệm, tình bạn, và những bài học quý giá trong hành trình.\"\r\n', 1),
(14, 'Chí Phèo', 'Nam Cao', 'Văn học', 'chipheo.jpg', 75000.00, 20, 'Chí Phèo là một trong những tác phẩm nổi tiếng nhất của văn học hiện thực phê phán Việt Nam. Câu chuyện xoay quanh cuộc đời bi thảm của Chí Phèo, một người nông dân lương thiện trở thành kẻ côn đồ sau khi bị xã hội đẩy vào cùng đường. Tác phẩm thể hiện rõ nét những bất công, tủi nhục mà người nông dân phải chịu đựng dưới chế độ phong kiến, đồng thời phản ánh sâu sắc tâm trạng, nỗi cô đơn và khao khát tình yêu của Chí Phèo.', 'Tác phẩm được đánh giá cao về mặt nghệ thuật và giá trị nhân văn. Độc giả cảm nhận được sự đau đớn và bi kịch của nhân vật, cũng như sự tàn nhẫn của xã hội. Chí Phèo không chỉ là một tác phẩm văn học mà còn là một tác phẩm xã hội mang tính thời đại.', 'Nam Cao (tên thật là Trí Phương) là một trong những nhà văn lớn của văn học Việt Nam, nổi bật với phong cách hiện thực phê phán. Ông viết nhiều tác phẩm phản ánh cuộc sống của tầng lớp nông dân, thể hiện rõ những nỗi khổ và ước mơ của họ trong xã hội phong kiến.', 1500, NULL, '): \"Chí Phèo sinh ra trong một gia đình nông dân nghèo, cha mẹ mất sớm, cậu phải tự mình nuôi sống bản thân. Cuộc đời Chí trôi qua êm đềm cho đến khi có một biến cố xảy ra, Chí bị vu oan, bị giam giữ và bị xã hội quay lưng. Sau khi ra tù, Chí trở thành một con người hoàn toàn khác. Chí không còn là một người nông dân hiền lành, mà trở thành một kẻ côn đồ, chuyên gây rối và làm phiền người khác.\r\nTại một quán rượu, Chí gặp Thị Nở, một cô gái xinh đẹp nhưng cũng tội nghiệp không kém. Thị Nở bị người đời xa lánh vì vẻ ngoài xấu xí. Dù không ai dám đến gần, nhưng Chí lại cảm thấy một sự kết nối đặc biệt với cô. Họ đã có những khoảnh khắc hạnh phúc bên nhau, và Chí dường như tìm thấy ánh sáng trong cuộc sống đen tối của mình.\r\nTuy nhiên, xã hội không chấp nhận tình yêu của họ. Chí bị người khác xô đẩy, bị mỉa mai và khinh thường. Một lần nữa, sự tàn nhẫn của xã hội đẩy Chí vào hố sâu của tuyệt vọng. Chí dần dần mất đi nhân tính và lún sâu vào con đường tội lỗi. Những cơn say trở thành bạn đồng hành, và Chí dần trở thành một con quỷ dữ trong mắt mọi người.\r\nĐến một ngày, trong cơn say, Chí quyết định phải tìm lại chính mình. Chí tìm đến Thị Nở, người duy nhất hiểu và chấp nhận Chí. Họ cùng nhau trải qua những ngày hạnh phúc nhưng không kéo dài lâu. Thế giới bên ngoài vẫn không ngừng tàn nhẫn, và cuối cùng, Chí phải trả giá cho những lựa chọn của mình. Hành trình của Chí Phèo không chỉ là câu chuyện về một người, mà còn là một bức tranh toàn cảnh về xã hội Việt Nam thời kỳ đó, đầy rẫy những bất công và tủi nhục.\"\r\n', 1),
(15, 'Làng nghề', 'Nguyễn Khắc Phê', 'Văn học', 'langnghe.jpg', 50000.00, 28, 'Làng Nghề là tác phẩm nổi bật trong thể loại văn học miêu tả cuộc sống của người dân quê hương Việt Nam. Tác phẩm không chỉ đơn thuần khắc họa hình ảnh những người thợ thủ công tài ba, mà còn phản ánh nét đẹp văn hóa truyền thống của làng quê Việt Nam. Qua những câu chuyện đời thường, tác giả thể hiện tình yêu quê hương, đất nước và những giá trị nhân văn cao đẹp.', 'Độc giả cảm nhận được sự gần gũi và chân thật trong từng câu chữ. Tác phẩm gợi nhớ về những kỷ niệm đẹp của tuổi thơ và tình yêu với làng quê, khiến người đọc không khỏi bồi hồi.', 'Nguyễn Khắc Phê là một nhà văn nổi tiếng trong văn học Việt Nam, được biết đến với những tác phẩm viết về nông thôn và cuộc sống của người dân. Ông thường khắc họa những giá trị văn hóa truyền thống, thể hiện tình yêu quê hương đất nước trong mỗi tác phẩm của mình.', 1300, NULL, '\"Trong một làng nhỏ, có những người thợ làm nghề truyền thống từ bao đời nay. Họ là những người giàu kinh nghiệm, khéo léo và tâm huyết với công việc. Những ngày mùa hè, họ thường tụ tập bên những chiếc bàn làm việc, cùng nhau tán gẫu và làm việc. Tiếng cười nói, tiếng nhạc cụ ngân vang tạo nên không khí ấm áp, gần gũi.\r\n\"Ông lão Tám, một người thợ mộc kỳ cựu, là người được nhiều người trong làng kính trọng. Ông có khả năng tạo ra những sản phẩm từ gỗ với độ chính xác và tinh xảo đến từng chi tiết. Những sản phẩm của ông không chỉ đơn thuần là đồ dùng trong gia đình mà còn mang đậm dấu ấn văn hóa và tinh thần của làng quê. Mỗi khi ông làm xong một sản phẩm mới, mọi người lại kéo đến ngắm nhìn và trầm trồ khen ngợi.\r\nCạnh nhà ông Tám là bà Mơ, một người thợ dệt lụa nổi tiếng. Những chiếc khăn, áo lụa của bà không chỉ được dân làng ưa chuộng mà còn được nhiều người từ các nơi khác biết đến. Bà Mơ tâm huyết với nghề, mỗi sản phẩm đều được bà tỉ mỉ chăm sóc. Bà thường bảo: \"Lụa không chỉ là vải, nó là linh hồn của người thợ dệt.\" Mỗi lần đi chợ, bà Mơ lại mang theo một vài sản phẩm của mình để bán. Người dân trong làng đều ủng hộ bà, bởi lụa của bà không chỉ đẹp mà còn mang đến sự tự hào cho quê hương.\r\nLàng nghề không chỉ nổi tiếng với những người thợ khéo tay mà còn là nơi gìn giữ những phong tục tập quán đặc sắc. Mỗi năm, làng tổ chức lễ hội truyền thống, nơi người dân tụ tập để tưởng nhớ tổ tiên và cầu mong cho vụ mùa bội thu. Trong lễ hội, các nghệ nhân trình diễn những nghề truyền thống, từ làm gốm, dệt vải đến điêu khắc. Không khí nhộn nhịp, vui tươi khiến người dân quên đi những lo toan thường nhật.\r\nNhân vật chính của câu chuyện là một chàng trai trẻ tên là Hòa, người rất yêu thích nghề truyền thống của làng. Hòa đã từng thấy ông Tám làm những sản phẩm tuyệt đẹp và ước mơ được học hỏi từ ông. Một ngày, Hòa quyết định đến tìm ông Tám để học nghề. Ông Tám vui mừng khi có một người trẻ tuổi yêu nghề, ông nhận Hòa làm học trò. Từ đó, Hòa cùng ông lão Tám làm việc mỗi ngày, học hỏi từng chi tiết, từng kỹ thuật.\r\nHòa không chỉ học được những kỹ năng mà còn thấu hiểu được tâm huyết của người thợ. Ông Tám dạy Hòa rằng: \"Mỗi sản phẩm đều phải chứa đựng tình yêu, sự kiên nhẫn và cả tâm hồn của người làm ra nó.\" Hòa cảm nhận được rằng nghề truyền thống không chỉ là công việc mà còn là một phần không thể thiếu trong cuộc sống, là cầu nối giữa quá khứ và tương lai.\r\nTheo thời gian, Hòa đã trở thành một thợ mộc giỏi, và sản phẩm của anh bắt đầu được người dân yêu thích. Anh không ngừng tìm tòi, sáng tạo, nhưng luôn giữ gìn những giá trị truyền thống. Hòa tổ chức các lớp dạy nghề cho những thanh niên khác trong làng, giúp họ hiểu và yêu nghề như anh.\r\nCuối cùng, Hòa trở thành một người thợ mộc nổi tiếng không chỉ trong làng mà còn ở nhiều nơi khác. Anh nhận ra rằng giá trị của nghề không chỉ nằm ở sản phẩm mà còn ở sự kết nối với cộng đồng, với văn hóa và lịch sử của quê hương. Hòa quyết tâm tiếp tục gìn giữ và phát triển nghề truyền thống, mang lại niềm tự hào cho cả làng.\r\nCâu chuyện kết thúc với hình ảnh Hòa đứng bên cạnh ông Tám, nhìn ra cánh đồng xanh rờn, trong lòng tràn ngập niềm hạnh phúc. Họ biết rằng công việc của họ không chỉ là nghề mà còn là một di sản quý báu, sẽ được truyền lại cho những thế hệ mai sau.\"\r\n', 1),
(16, 'Vợ nhặt', 'Kim Lân', 'Văn học', 'vonhat.jpg', 65000.00, 50, 'Vợ Nhặt là một tác phẩm nổi tiếng của nhà văn Kim Lân, phản ánh cuộc sống khốn khổ của người nông dân trong thời kỳ đói kém sau Cách mạng tháng Tám. Câu chuyện xoay quanh nhân vật Tràng, một người nông dân nghèo, trong hoàn cảnh tuyệt vọng đã vô tình nhặt được vợ. Tác phẩm mang đậm giá trị nhân văn, thể hiện khát vọng sống và tình yêu thương giữa con người trong bối cảnh khó khăn.', 'Tác phẩm được độc giả đánh giá cao vì sự chân thực và sâu sắc. Kim Lân khéo léo lồng ghép giữa tình yêu và nỗi đau, giúp người đọc cảm nhận được cuộc sống bần hàn nhưng vẫn đầy ắp tình người.', 'Kim Lân là một trong những nhà văn tiêu biểu của văn học Việt Nam, nổi tiếng với những tác phẩm phản ánh cuộc sống và tâm tư của người nông dân. Ông có khả năng khắc họa chân thực những giá trị văn hóa và tâm hồn con người trong bối cảnh xã hội đầy biến động.', 2000, NULL, '\"Tràng, một người nông dân sống trong một làng quê nghèo, mỗi ngày vật lộn với cái đói và cái rét. Cuộc sống của Tràng đơn điệu và buồn tẻ, nhưng anh không hề nản lòng. Một ngày nọ, trong khi đang loay hoay tìm kiếm thức ăn, Tràng tình cờ gặp một cô gái xinh đẹp nhưng gầy gò, tên là Vệ. Cô đã bỏ nhà ra đi, không còn nơi nào để về.\r\nTràng đưa Vệ về nhà mình, và từ đó, họ bắt đầu sống cùng nhau. Tràng bất ngờ khi nhận ra rằng Vệ đã trở thành niềm hy vọng cho cuộc sống của mình. Mặc dù cuộc sống còn nhiều khó khăn, nhưng tình yêu giữa họ dần nảy nở. Họ cùng nhau chia sẻ những bữa cơm đơn giản, cùng mơ ước về một tương lai tốt đẹp hơn.\r\nMỗi tối, Tràng thường ngồi bên Vệ, kể cho cô nghe về những giấc mơ của mình. Anh mơ ước có một cuộc sống đủ đầy, có ruộng vườn và con cái. Vệ lắng nghe, đôi mắt lấp lánh hy vọng. Dù biết rằng mọi thứ vẫn còn rất xa vời, nhưng họ không ngừng ủng hộ nhau.\r\nMột hôm, trong lúc họ đang cùng nhau nấu ăn, Tràng chợt nhận ra rằng cuộc sống của mình đã thay đổi từ khi có Vệ. Tràng không còn đơn độc, mà có người sẻ chia nỗi buồn và niềm vui. Họ đã tìm thấy một ánh sáng trong cuộc sống tăm tối này.\r\nTuy nhiên, cuộc sống không hề dễ dàng. Đói kém, bệnh tật và áp lực xã hội vẫn bủa vây họ. Vệ luôn lo lắng về tương lai, còn Tràng thì cố gắng động viên cô. Họ cùng nhau vượt qua những khó khăn, tìm kiếm những cơ hội để cải thiện cuộc sống.\r\nVào một buổi sáng, Tràng quyết định đi tìm việc làm. Anh muốn tích góp tiền để mua thức ăn và chăm sóc Vệ. Tràng đi khắp nơi, từ làng này sang làng khác, nhưng không ai nhận anh. Tuy nhiên, anh không từ bỏ. Cuối cùng, anh tìm được một công việc trong một trang trại gần đó.\r\nDù công việc rất vất vả, Tràng vẫn luôn nghĩ về Vệ, về tương lai mà họ cùng nhau xây dựng. Anh thường mang về những món quà nhỏ từ công việc, những thứ mà anh nghĩ sẽ làm Vệ vui. Họ cùng nhau tạo dựng tổ ấm từ những điều giản dị.\r\nMột ngày nọ, Tràng quyết định tổ chức một buổi tiệc nhỏ để ăn mừng tình yêu của họ. Anh mời những người bạn của mình đến, cùng nhau chia sẻ niềm hạnh phúc. Vệ rất vui khi thấy mọi người đến dự, và cô tự tay chuẩn bị món ăn. Tình yêu giữa họ đã lan tỏa, và mọi người trong làng đều biết về câu chuyện của họ.\r\nKhi buổi tiệc kết thúc, Tràng ngồi bên Vệ, nhìn về tương lai với đầy hy vọng. Anh biết rằng cuộc sống vẫn còn nhiều thử thách, nhưng với tình yêu và sự kiên trì, họ sẽ vượt qua tất cả. Họ đã tìm thấy nhau giữa những khốn khó, và đó chính là điều quý giá nhất trong cuộc đời.\"\r\n', 1),
(17, 'Truyện Kiều', 'Nguyễn Du', 'Văn học', 'truyenkieu.jpg', 95000.00, 22, 'Truyện Kiều là một trong những tác phẩm vĩ đại nhất của văn học Việt Nam. Tác phẩm kể về cuộc đời đầy bi kịch của Kiều, một người con gái tài sắc nhưng gặp phải nhiều bất hạnh. Với những tình tiết cảm động, tác phẩm không chỉ phản ánh tâm tư của con người mà còn thể hiện sâu sắc những giá trị đạo đức và nhân văn.', 'Tác phẩm được ca ngợi không chỉ vì nội dung sâu sắc mà còn bởi hình thức nghệ thuật tinh tế. Nguyễn Du đã sử dụng ngôn ngữ thơ ca để khắc họa những hình ảnh, tâm trạng của nhân vật một cách sinh động.', 'Nguyễn Du là một trong những nhà thơ vĩ đại nhất của văn học cổ điển Việt Nam, nổi tiếng với khả năng sử dụng ngôn ngữ và hình ảnh để thể hiện tâm tư, tình cảm con người. Tác phẩm của ông thường mang giá trị nhân văn sâu sắc và phản ánh chân thực cuộc sống.', 2500, NULL, '\"Truyện Kiều bắt đầu với hình ảnh của Thúy Kiều, một cô gái xinh đẹp, tài năng và thông minh. Tuy nhiên, số phận của cô lại không được may mắn như vẻ bề ngoài. Trong một lần tình cờ, Kiều đã phải lòng Kim Trọng, một chàng trai hiền lành và học thức. Họ đã có những khoảnh khắc hạnh phúc bên nhau, nhưng tình yêu của họ không thể bền lâu do hoàn cảnh éo le.\r\nCha mẹ Kiều buộc phải gả cô cho một người khác để trả nợ. Kiều chấp nhận hy sinh bản thân vì gia đình, nhưng cô không thể quên được tình yêu đầu đời. Cuộc sống hôn nhân với người chồng không yêu thương khiến Kiều chìm trong khổ đau. Cô quyết định bỏ trốn để tìm về bên Kim Trọng, nhưng mọi thứ lại không như cô mong đợi.\r\nTrên đường tìm kiếm tình yêu, Kiều phải đối mặt với nhiều thử thách, từ những người đàn ông tàn nhẫn đến những tình huống hiểm nguy. Mỗi lần rơi vào tình cảnh tuyệt vọng, Kiều lại cảm thấy đau đớn hơn về tình yêu đã mất. Cô luôn tự hỏi: \"Tại sao cuộc đời lại tàn nhẫn với cô như vậy?\".\r\nTrong hành trình tìm kiếm, Kiều đã gặp gỡ nhiều nhân vật khác, mỗi người mang đến cho cô những bài học và góc nhìn mới về cuộc sống. Tuy nhiên, những nỗi đau vẫn cứ đeo bám Kiều, khiến cô không thể tìm thấy bình yên trong tâm hồn.\r\nCuối cùng, sau nhiều năm tháng vật lộn, Kiều cũng tìm lại được Kim Trọng. Tuy nhiên, tình yêu của họ đã bị vùi dập bởi thời gian và số phận. Họ không thể quay lại như trước, và Kiều hiểu rằng những gì mình đã mất không thể nào lấy lại được.\r\nTruyện Kiều kết thúc với hình ảnh Kiều trở về quê hương, mang trong mình nỗi niềm đau xót. Cô đã trải qua nhiều biến cố, nhưng cô vẫn giữ được phẩm giá và lòng tự trọng. Tác phẩm không chỉ phản ánh số phận bi thảm của Kiều mà còn là bức tranh chân thực về đời sống xã hội, về những ước mơ và khát vọng của con người.\r\nNguyễn Du đã khéo léo lồng ghép những tư tưởng triết lý, những giá trị nhân văn trong tác phẩm, khiến Truyện Kiều trở thành một kiệt tác không thể thiếu trong nền văn học Việt Nam. Đến nay, câu chuyện của Kiều vẫn sống mãi trong lòng người đọc, là bài học về tình yêu, lòng kiên trì và nhân phẩm.\"\r\n', 1),
(18, 'Thao túng tâm lý', 'Robert Cialdini', 'Tâm lý học', 'thaotungtamly.jpg', 110000.00, 10, 'Thao Túng Tâm Lý là một cuốn sách nổi tiếng về tâm lý học và nghệ thuật thuyết phục. Tác giả Robert Cialdini đã phân tích các nguyên tắc thuyết phục trong giao tiếp và ứng xử xã hội. Qua đó, độc giả sẽ hiểu rõ hơn về cách mà tâm lý con người hoạt động và các kỹ thuật để gây ảnh hưởng đến người khác.', 'Cuốn sách được độc giả đánh giá cao vì tính ứng dụng thực tiễn và những nghiên cứu khoa học sâu sắc. Cialdini sử dụng nhiều ví dụ cụ thể và câu chuyện thú vị để minh họa cho các nguyên tắc mà ông đưa ra.', 'Robert Cialdini là một nhà tâm lý học nổi tiếng, được biết đến với các nghiên cứu về thuyết phục và ảnh hưởng. Ông là tác giả của nhiều cuốn sách best-seller, trong đó có Thao Túng Tâm Lý, cuốn sách đã trở thành tài liệu tham khảo không thể thiếu cho những ai quan tâm đến lĩnh vực này.', 3000, NULL, '\"Cuốn sách bắt đầu với việc tác giả giới thiệu về khái niệm thuyết phục. Cialdini cho rằng thuyết phục không chỉ đơn thuần là khả năng nói chuyện mà còn là việc hiểu và tác động đến tâm lý người khác. Ông chia sẻ rằng để thuyết phục ai đó, bạn cần phải nắm vững một số nguyên tắc cơ bản.\r\nNguyên tắc đầu tiên mà Cialdini đề cập đến là sự đồng nhất. Con người có xu hướng cảm thấy thoải mái hơn khi họ được làm theo điều mà họ đã nói trước đó. Do đó, nếu bạn muốn thuyết phục ai đó làm điều gì đó, hãy khiến họ cam kết hoặc thừa nhận trước.\r\nTiếp theo, Cialdini nói về nguyên tắc tương tự. Con người dễ dàng bị thuyết phục bởi những người mà họ cảm thấy có điểm chung với mình. Điều này có nghĩa là nếu bạn có thể tạo dựng được một mối liên kết hoặc sự tương đồng với người khác, bạn sẽ dễ dàng hơn trong việc thuyết phục họ.\r\nNguyên tắc tiếp theo là xã hội hóa. Con người thường tìm kiếm sự xác nhận từ những người xung quanh trước khi đưa ra quyết định. Do đó, khi bạn muốn thuyết phục ai đó, hãy cho họ thấy rằng nhiều người khác cũng đã lựa chọn điều đó.\r\nCialdini còn chia sẻ về nguyên tắc khan hiếm. Con người thường đánh giá cao những gì hiếm có hơn là những gì dễ dàng có được. Nếu bạn muốn thuyết phục ai đó, hãy tạo ra cảm giác khan hiếm cho sản phẩm hoặc dịch vụ của bạn.\r\nTác giả còn rất khéo léo khi kết hợp những câu chuyện thực tế, ví dụ như trong lĩnh vực tiếp thị hay chính trị, để minh họa cho từng nguyên tắc. Điều này giúp người đọc dễ dàng hiểu và nhớ được các khái niệm mà ông đề cập.\r\nCialdini cũng không ngần ngại chia sẻ những mẹo nhỏ giúp độc giả có thể áp dụng các nguyên tắc này trong cuộc sống hàng ngày. Ông nhấn mạnh rằng thuyết phục không có nghĩa là lừa dối, mà là nghệ thuật tạo ra những tình huống mà cả hai bên đều cảm thấy có lợi.\r\nCuốn sách khép lại với thông điệp: \"Thuyết phục không phải là việc làm cho người khác làm theo ý mình, mà là việc tạo ra những giá trị chung.\" Cialdini đã thành công trong việc giúp người đọc không chỉ hiểu rõ hơn về tâm lý con người mà còn biết cách áp dụng kiến thức đó vào thực tiễn.\"\r\n', 1),
(19, 'Sổ tay nhà thôi miên', 'Richard Nongard', 'Tâm lý học', 'sotaynhathoimien.jpg', 145000.00, 43, 'Sổ Tay Nhà Thôi Miên là một cuốn sách hữu ích cho những ai quan tâm đến thôi miên và sức mạnh của tâm trí. Richard Nongard, tác giả cuốn sách, đã chia sẻ những kiến thức, kỹ thuật và kinh nghiệm quý báu trong lĩnh vực thôi miên. Cuốn sách không chỉ dành cho những nhà thôi miên chuyên nghiệp mà còn cho bất kỳ ai muốn khám phá sức mạnh của tâm trí.', 'Cuốn sách nhận được nhiều đánh giá tích cực từ độc giả vì tính thực tiễn và dễ hiểu. Các kỹ thuật thôi miên trong sách được trình bày một cách chi tiết, dễ áp dụng.', 'Richard Nongard là một nhà thôi miên, diễn giả và tác giả nổi tiếng. Ông đã có nhiều năm kinh nghiệm trong lĩnh vực thôi miên và đào tạo. Tác phẩm của ông thường mang tính ứng dụng cao và tập trung vào việc phát triển kỹ năng cá nhân.', 4000, NULL, '\"Cuốn sách bắt đầu với việc tác giả giới thiệu về khái niệm thôi miên và lịch sử phát triển của nó. Richard Nongard nhấn mạnh rằng thôi miên không phải là phép thuật, mà là một kỹ thuật giao tiếp giữa tâm trí của người thôi miên và người được thôi miên.\r\nÔng cung cấp những nguyên tắc cơ bản của thôi miên, từ cách tạo dựng một môi trường thích hợp cho đến cách giao tiếp với người khác để đưa họ vào trạng thái thôi miên. Richard cũng chia sẻ về tầm quan trọng của việc thiết lập niềm tin và sự thoải mái giữa nhà thôi miên và người được thôi miên.\r\nSau đó, tác giả đi sâu vào các kỹ thuật thôi miên cụ thể, bao gồm các phương pháp như thôi miên qua hình ảnh, thôi miên ngôn ngữ, và thôi miên cảm xúc. Mỗi kỹ thuật đều được giải thích chi tiết kèm theo ví dụ thực tế, giúp người đọc dễ dàng hình dung và áp dụng.\r\nRichard còn chia sẻ về cách thôi miên trong các tình huống thực tế, từ việc giảm căng thẳng, tăng cường sự tự tin, cho đến việc điều chỉnh hành vi. Ông khẳng định rằng thôi miên có thể là công cụ mạnh mẽ để thay đổi những thói quen xấu và tạo ra những kết quả tích cực trong cuộc sống.\r\nMột phần thú vị trong cuốn sách là các bài tập thực hành mà tác giả đề xuất. Richard khuyến khích độc giả thực hành các kỹ thuật thôi miên trong cuộc sống hàng ngày, từ việc giao tiếp với bạn bè, gia đình cho đến trong công việc. Ông cho rằng việc thực hành sẽ giúp người đọc nắm vững kiến thức và trở thành một nhà thôi miên thành công.\r\nCuốn sách kết thúc với một chương về tầm quan trọng của đạo đức trong thôi miên. Richard nhấn mạnh rằng nhà thôi miên không chỉ có trách nhiệm với bản thân mà còn với người khác. Họ cần phải sử dụng sức mạnh của thôi miên một cách có đạo đức và có trách nhiệm.\r\nSổ Tay Nhà Thôi Miên không chỉ là một tài liệu hướng dẫn cho những ai muốn trở thành nhà thôi miên, mà còn là nguồn cảm hứng cho bất kỳ ai muốn khám phá sức mạnh tiềm ẩn của tâm trí.\"\r\n', 1),
(20, 'Phía sau nghi can X', 'Higashino Keigo', 'Trinh thám', 'phiasaunghicanX.jpg', 170000.00, 35, 'Phía Sau Nghi Can X là một tiểu thuyết trinh thám nổi tiếng của tác giả Higashino Keigo. Câu chuyện xoay quanh một vụ án giết người ly kỳ, nơi mà mọi nghi vấn đều đổ dồn về một người đàn ông có vẻ ngoài bình thường nhưng lại có khả năng phi thường. Tác phẩm không chỉ đơn thuần là một câu chuyện trinh thám mà còn sâu sắc khám phá tâm lý con người.', 'Cuốn sách nhận được sự yêu thích từ độc giả và được xem như một trong những tác phẩm trinh thám xuất sắc nhất. Higashino Keigo đã khéo léo xây dựng cốt truyện với nhiều bất ngờ, cùng những tình tiết hấp dẫn.', 'Higashino Keigo là một trong những tác giả trinh thám nổi tiếng nhất Nhật Bản. Ông được biết đến với khả năng xây dựng cốt truyện độc đáo và sâu sắc về tâm lý con người. Tác phẩm của ông thường chứa đựng những bất ngờ và những tình tiết ly kỳ.', 5000, NULL, '\"Câu chuyện mở đầu với hình ảnh của một cô gái trẻ bị sát hại trong một ngôi nhà hoang. Các điều tra viên, dẫn đầu là thám tử Kusanagi, được giao nhiệm vụ giải quyết vụ án bí ẩn này. Vụ án trở nên phức tạp khi mọi nghi vấn đều chỉ vào một người đàn ông tên là Ishigami, một giáo viên toán có tính cách kỳ lạ và ít giao tiếp với người khác.\r\nIshigami luôn xuất hiện bình thản, nhưng bên trong lại là một tâm hồn đầy đau đớn và bất an. Ông yêu cô gái bị sát hại, nhưng không có can đảm để bày tỏ tình cảm. Khi vụ án diễn ra, Ishigami trở thành nghi can chính, và các bằng chứng đều dồn ép ông vào thế bí. Tuy nhiên, điều kỳ lạ là Ishigami lại không có động cơ rõ ràng để phạm tội.\r\nTrong khi các điều tra viên đang nỗ lực tìm kiếm chứng cứ, một người phụ nữ tên là Yukawa, một người bạn cũ của Ishigami, quyết định can thiệp. Yukawa là một nhà vật lý nổi tiếng, người có khả năng giải mã những vấn đề phức tạp. Cô quyết định gặp Ishigami để tìm hiểu sự thật về vụ án.\r\nTrong cuộc trò chuyện, Yukawa cảm nhận được nỗi đau và những cảm xúc mà Ishigami đang giấu kín. Anh ta luôn khẳng định rằng mình vô tội, và Yukawa tin rằng có điều gì đó bí ẩn đang ẩn giấu. Cô bắt đầu điều tra thêm về quá khứ của Ishigami, và dần dần phát hiện ra những tình tiết đáng ngờ.\r\nCâu chuyện dần đi đến cao trào khi Yukawa tìm thấy một bức thư mà Ishigami viết cho cô gái bị sát hại, trong đó thể hiện tình cảm chân thành nhưng cũng đầy bi kịch. Ishigami đã tạo ra một kế hoạch tinh vi để bảo vệ cô gái, nhưng kế hoạch của anh lại biến thành thảm họa.\r\nCuối cùng, Yukawa phải đối mặt với sự thật khủng khiếp. Ishigami thực sự có liên quan đến vụ án, nhưng động cơ của anh không phải là giết người mà là một tình yêu đau thương. Cô nhận ra rằng mọi thứ không bao giờ đơn giản như vẻ bề ngoài, và có những điều mà chỉ những người trong cuộc mới hiểu rõ.\r\nCâu chuyện kết thúc với hình ảnh Yukawa đứng bên mộ cô gái, lòng đầy trăn trở. Tác phẩm không chỉ là một cuộc điều tra về một vụ án mà còn là một khám phá sâu sắc về tâm lý con người, về tình yêu, sự hy sinh và nỗi đau. Higashino Keigo đã khéo léo xây dựng một cốt truyện hấp dẫn, kết hợp giữa yếu tố trinh thám và nhân văn.\"\r\n', 1);

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
