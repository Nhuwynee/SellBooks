package com.example.bansach.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.example.bansach.R;

public class ReadBookFragment extends Fragment {

    private TextView tvBookTitle, tvSampleContent;
    private ImageView imgBookCover;
    private Button btnBuyNow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_readbook, container, false);

        // Khởi tạo các view
        tvBookTitle = view.findViewById(R.id.tvBookTitle);
        tvSampleContent = view.findViewById(R.id.tvSampleContent);
        imgBookCover = view.findViewById(R.id.imgBookCover);
        btnBuyNow = view.findViewById(R.id.btnBuyNow);

        // Đặt dữ liệu cho các view
        tvBookTitle.setText("Hồng lục");
        tvSampleContent.setText("Chương 1: Nữ thần quay về rồi\n" +
                "\n" +
                "Tinh tinh tinh, nhóm đại học lâu lắm không có ai điểm danh đột nhiên trở nên sôi động trở lại, Hách Thúy Thúy vào xem, thì ra là Nhan Dịch Ngữ về nước. Cậu ta năm hai đại học xuất ngoại, đến nay được bốn năm rồi, nghe nói đã học xong thạc sĩ, bây giờ mang tiếng thơm về nước.\n" +
                "\n" +
                "Trong nhóm sôi nổi đòi họp mặt làm tiệc tiếp đãi, bàn luận vui đến tung trời. Thậm chí có người ngay cả ảnh chụp chung với nữ thần cũng gửi vào trong nhóm. Hội ăn dưa kịch liệt lên án, nói anh ta ủ mưu, thế mà đã liên lạc riêng với nữ thần rồi!\n" +
                "\n" +
                "Vị huynh đài gửi ảnh nọ vội vã giải thích, là gặp ở sân bay có được không hả!!\n" +
                "\n" +
                "Hách Thúy Thúy chẳng quan tâm buổi họp mặt bạn bè sẽ được tổ chức ở đâu, thời gian lúc nào, cô nhìn chằm chằm vào người con gái rực rỡ như ánh hào quang, cái bụng nhỏ đầy phiền muộn!\n" +
                "\n" +
                "Nhìn người ta kìa! Ở nơi đất khác quê người xa lạ như vậy, mà vẫn giữ được tâm thái!\n" +
                "\n" +
                "Cô ném điện thoại, dẩu môi đi tìm thẻ tập gym của mình. Tìm được mấy tấm thì đều hết hạn cả rồi.\n" +
                "\n" +
                "Cô phiền não gửi tin nhắn qua cho bạn thân, muốn cô ấy theo mình đến phòng gym tập luyện. Khương Vân chả buồn phản ứng, chế nhạo cô lại muốn tặng tiền phòng tập gym à, Hách Đồng Quang nhà mi có biết mi đi nuôi đàn ông bên ngoài không?\n" +
                "\n" +
                "Hách Thúy Thúy nằm ườn trên sô pha, cực kỳ mất hình tượng, cô thở dài một cách khoa trương, ta muốn người cũng như tên Khương Tiểu Vân à(*).\n" +
                "\n" +
                "((*)Ý bà chị là cũng muốn mình trở nên đẹp đẽ trong trẻo như ngọc phỉ thúy trong tên bà ý)\n" +
                "\n" +
                "Trước đây Khương Vân từng trêu tên cô, nói vừa nhìn thấy cô là muốn đội mũ cho cô rồi. Nhưng sau khi cô và Hách Đồng Quang kết hôn, Khương Vân không nhắc lại chuyện này nữa. Bỗng nhận ra gì đó, ông anh cô đội mũ cho cô sao? (*)\n" +
                "\n" +
                "(*) Ý là ông anh trai ngoại tình.\n" +
                "\n" +
                "Nữ chính hào quang vô hạn đã trở về, còn nữ phụ ăn no chờ chết sẽ có kết cục gì? Cô đau đớn ra sức uống trà, sau đó nghiến răng nghiến lợi đợi nam chính về nhà gây sự.\n" +
                "\n" +
                "Nam chính mặc sơ mi trắng, ồ, trên tay đã cầm cà vạt rồi, bây giờ đang tháo đồng hồ, hình như mới từ tiệc rượu nào đó về.\n" +
                "\n" +
                "Đúng là cảnh đẹp ý vui!\n" +
                "\n" +
                "Cô cho rằng lúc này, trong mắt nam chính sẽ đầy vẻ xem thường, căm ghét, châm biếm gì đó, nhưng hiển nhiên, cái người nhà cô không phải là một nam chính bình thường.\n" +
                "\n" +
                "Anh cực kỳ bình tĩnh liếc qua TV, sau đó như một thói quen cà ràm một câu, nói xem ít mấy thứ thiểu năng thôi.\n" +
                "\n" +
                "Tuy rằng phim truyền hình là thiểu năng, nhưng thực sự không phải cô vì quá đần mà! Có điều cô muốn nghĩ sao thì nghĩ, dù sao thì trong lòng anh ấy cô cũng không thể ngốc thêm được.\n" +
                "\n" +
                "Hách Thúy Thúy chả quan tâm bĩu môi, tiếp tục rót trà.\n" +
                "\n" +
                "Mặc kệ Khương Vân oanh tạc trong wechat, Hách Thúy Thúy vẫn trước sau như một, ép cô ấy không thể không đồng ý ngày mai cùng Hách Thúy Thúy đi tìm phòng gym thích hợp.\n" +
                "\n" +
                "Lòng hiếu kỳ không được thỏa mãn, cuối cùng Khương Vân nhắn một tin độc ác tới, nguyền rủa cô cuộc sống sinh hoạt vợ chồng không được thỏa mãn!\n" +
                "\n" +
                "Hách Thúy Thúy rú lên một tiếng, bị Hách Đồng Quang kêu đi rủa mặt, tối đêm rồi còn gào thét cái gì vậy?\n" +
                "\n" +
                "Khương Vân nguyền rủa em không có cuộc sống vợ chồng như ý\n" +
                "\n" +
                "Anh có chuyện gì liên quan đến cậu ta không đấy?\n" +
                "\n" +
                "Hách Thúy Thúy không nghe theo, chạy vào nhà vệ sinh bổ nhào lên lưng anh, anh nói em có hay không?\n" +
                "\n" +
                "Hách Đồng Quang đã sớm nhìn thấy hành động của cô qua gương, ôm cô một cái rồi bất đắc dĩ nhìn cô. Hách Thúy Thúy không biết xấu hổ níu cổ anh hôn một cái, cuối cùng, thành công có được một trải nghiệm cực kỳ mỹ mãn.\n" +
                "\n" +
                "Cô uốn éo cọ cọ người anh, Hách Đồng Quang đặt cô lên bồn rửa mặt, tay từ quần áo với vào bên trong, vừa sờ soạn vừa hôn cô, “Lại không mặc đồ lót…”\n" +
                "\n" +
                "“Ở nhà không thích mặc…”\n" +
                "\n" +
                "Xong chuyện, cô đắc ý nhắn cho Khương Vân một tin, “Vui sướng của lão nương nhà người muốn tưởng tượng cũng không nổi.”\n" +
                "\n" +
                "Gửi xong tin nhắn Hách Thúy Thúy bị tịch thu điện thoại, bị nhắc nhở đi ngủ. Cô giả vờ ngoan ngoãn nằm ngủ, sau đó chui vào trong lòng chồng, luôn miệng mời gọi: “Anh trai yêu quý ơi, vừa rồi em thoải mái nhắm… anh ơi, anh thoải mái không… thịt em có phải rất mềm không…”\n" +
                "\n" +
                "Hách Đồng Quang không trả lời, anh biết nếu mà để ý đến cô, đêm nay khỏi mong yên ổn, nhưng Hách Thúy Thúy là người biết khó mà lui sao? Không, càng khó cô càng nhảy vào.\n" +
                "\n" +
                "“Anh trai yêu quý ơi, em bên dưới lại ướt rồi…”\n" +
                "\n" +
                "Hách Đồng Quang nuốt một ngụm nước bọt, kêu lên một tiếng. Hai mắt Hách Thúy Thúy phát sáng, lập tức sà tới muốn ôm hôn, tách hai chân dán lên, dường như muốn chứng minh mình không nói dối.\n" +
                "\n" +
                "“Em muốn anh tẫn tinh đến chết phải không?”\n" +
                "\n" +
                "Hách Thúy Thúy cắn môi, bàn tay luồn vào trong quần áo ngủ sờ cơ bụng của anh, rì rầm nói, “Sao anh biết em muốn anh chết trên người em?”\n" +
                "\n" +
                "Hách Đồng Quang nghe xong, lập tức lật người đè cô, Hách Thúy Thúy lại được vui sướng rồi.\n" +
                "\n" +
                "Cô cảm thấy Hách Đồng Quang vẫn rất có cảm giác với mình, vậy cô và Nhan Dịch Ngữ kia vẫn còn một trận đấu tranh thực lực.\n" +
                "\n" +
                "Nói đến đây, thật xấu hổ cô với Hách Đồng Quang hoàn toàn không phải kết hôn vì tình yêu!\n" +
                "\n" +
                "Hai người là rượu vào loạn tình bị bố mẹ bắt được…\n" +
                "\n" +
                "Hách Thúy Thúy che mặt.\n" +
                "\n" +
                "Đúng là đen đủi! Lần đầu đã…\n" +
                "\n" +
                "Đương nhiên, lần thứ mấy ở trong mắt bố mẹ cũng không quan trọng. Hơn nữa năm đó ông nội nhặt được Hách Thúy Thúy đã tính toán muốn nuôi cô thành vợ cho cháu trai, tuy rằng mọi người không coi là thật, nhưng đưa đẩy thế nào, kết hôn lại thành thích hợp nhất.\n" +
                "\n" +
                "Sau đó, hai người vừa tới tuổi kết hôn thì được bố mẹ dẫn đi đăng ký.\n" +
                "\n" +
                "Hách Thúy Thúy đồng ý một cách cực kỳ thoải mái, đương nhiên bởi vì chuyện này với cô chỉ có lợi không có hại. Đầu tiên, đạo đức và tính cách của Hách Đồng Quang cô rất rõ ràng, hai người ở chung không cần tốn thời gian làm quen. Quan trọng, bố mẹ chồng chính là bố mẹ mình rồi, cái này còn cần phải bàn sao! Cuối cùng, cô không cần phải đi làm.\n" +
                "\n" +
                "Cảm tạ trời đất, bởi cô chẳng có bản lĩnh gì, lại chịu không nổi khổ, Hách Đồng Quang chăm mạ (*) nhiều năm như vậy, cô vẫn là một gốc mạ vô dụng.\n" +
                "\n" +
                "(*)揠苗助长 ý là để mạ lớn nhanh nên kéo cây mạ lên để giúp nó, tương đương với câu “Giục tốc bất đạt”\n" +
                "\n" +
                "Trong nhà đã bàn bạc xong xuôi đợi cô kết hôn sẽ cho cô một ít bất động sản để cô cho thuê. Như vậy cô sẽ không quá khổ cực, cũng không cần nhìn sắc mặt nhà chồng để sống.\n" +
                "\n" +
                "Còn Hách Đồng Quang nghĩ như thế nào? Hách Thúy Thúy cũng từng hỏi qua, chủ yếu là trình bày những lợi ích của việc kết hôn, sau đó ngồi xổm trước mặt anh đáng thương nói: “Nếu anh thực không muốn kết hôn thì thôi vậy. Em đi nói với mẹ, không làm khó dễ anh nữa.”\n" +
                "\n" +
                "Hách Đồng Quang liếc cô một cái, như nhìn ra được tính toán nhỏ của cô: “Em nói?”\n" +
                "\n" +
                "Lúc đó trong lòng Hách Thúy Thúy nảy lên một cái, “Em… nếu ông nội biết… không biết ở dưới đó vui mừng đến thế nào.”\n" +
                "\n" +
                "Hách Đồng Quang cười lạnh một cái, “Nếu ông nội biết được chuyện em hồi năm nhất, sẽ không vui được đâu.”\n" +
                "\n" +
                "Hách Thúy Thúy chột dã, “Đó là đùa bỡn…”\n" +
                "\n" +
                "Cô thấy Hách Đồng Quang nhìn sách không để ý đến mình, sốt ruột: “Em với cậu ta còn chưa nắm tay! Em với anh còn ngủ với nhau rồi kìa! Tự anh đi tìm mẹ giải thích đi! Hừ!”\n" +
                "\n" +
                "Cô hậm hựm giậm chân rời đi.\n" +
                "\n" +
                "Sau đó bất an mấy ngày, cũng không thấy có biến cố gì, vẫn dựa theo kế hoạch đi đăng ký kết hôn.\n" +
                "\n" +
                "Còn Hách Đồng Quang, dường như không để tâm đến chuyện ngày đó, Hách Thúy Thúy tự nhiên còn quên nhanh hơn anh, tiếp tục trải qua những ngày không tim không phổi.");
        imgBookCover.setImageResource(R.drawable.hong_luc);

        // Xử lý sự kiện khi người dùng nhấn nút "Mua sách"
        btnBuyNow.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.container, new ViewBookFragment())
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }
}
