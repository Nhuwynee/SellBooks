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
        tvSampleContent.setText("Chương 1: Nữ thần quay về rồi" +
                "\n" + "Trên bàn cơm, qua ba tuần rượu, mọi người bắt đầu nhớ lại chuyện năm xưa.\n" +
                "\n" +
                "Hách Thúy Thúy: Ngoại trừ Nhan Dịch Ngữ chuyển ngành rồi đi du học, những người khác mới chia tay hai năm, có gì mà hoài niệm?\n" +
                "\n" +
                "Nói mấy chuyện linh tinh thời học sinh, rồi mấy chuyện mờ ám trong công việc. Uống hơi phiêu phiêu, bắt đầu hỏi sang chuyện tư.\n" +
                "\n" +
                "Hách Thúy Thúy là phụ nữ đã có chồng, Khương Vân là con nhà tri thức, chỉ có Nhan Dịch Ngữ tính tình vừa mềm mại vừa thần bí, câu thứ nhất chính là hỏi tình hình yêu đương và hôn nhân của Nhan Dịch Ngữ.\n" +
                "\n" +
                "Nhan Dịch Ngữ nói không có một cách tự nhiên, mấy người đàn ông lập tức ồn ào, có người nói ánh mắt cô nàng cao, có người nói do quá quan trọng sự nghiệp, “Cũng nên suy nghĩ đi, lớn tuổi khó sinh con!”\n" +
                "\n" +
                "“Chính là, phụ nữ không kết hôn không con cái vẫn là phụ nữ à?”\n" +
                "\n" +
                "Những người dẫn theo bạn gái hoặc vợ tới, không dám nói trắng trợn như thế, nhưng cũng cổ vũ: “Nhan mỹ nữ người theo đuổi nhiều quá chọn đến hoa mắt phải không?”\n" +
                "\n" +
                "Nhan Dịch Ngữ khẽ cúi đầu vuốt tóc, nụ cười trên mặt không quá rõ ràng.\n" +
                "\n" +
                "Tinh thần chính nghĩa của Hách Thúy Thúy dâng cao, đang muốn mở miệng, điện thoại của Nhan Dịch Ngữ đột nhiên vang lên, cô nàng nhận điện thoại rồi nói: “Được, lập tức tới ngay.” Sau đó đứng dậy nói xin lõi, công ty có việc gấp cần giải quyết, bữa hôm nay là do cô nàng mời.\n" +
                "\n" +
                "Nói xong liền xách túi đi, để lại làn hương lượn lờ.\n" +
                "\n" +
                "Đàn ông trên bàn đều không kịp phản ứng, Hách Thúy Thúy lén lút hỏi Hách Đồng Quang: “Sao công ty không có gọi anh vậy?”\n" +
                "\n" +
                "Vừa rồi anh không cẩn thận nhìn thấy thông báo cuộc gọi đến trên màn hình di động của Nhan Dịch Ngữ, đang có chút nghi ngờ. Nghe vậy nhìn cô, “Em hi vọng anh đi tăng ca à?”\n" +
                "\n" +
                "Cùng với Nhan Dịch Ngữ? Thôi dẹp đi…\n" +
                "\n" +
                "Hách Thúy Thúy bĩu môi nói: “Em chỉ lo lắng anh thất nghiệp thôi, hừ hừ.”\n" +
                "\n" +
                "Hách Đồng Quang gắp rau cho cô, “Thất nghiệp vẫn nuôi được em, không cần lo.”\n" +
                "\n" +
                "Đàn ông uống rượu với nhau là bắt đầu khoác lác, cũng chẳng ai bận tâm đến cơm nước trên bàn, chỉ có cô với Khương Vân ăn uống no say, Khương Vân đẩy nhẹ cô, “Bàn này đắt lắm, ban đầu là định ăn cho hồi vốn, chẳng ngờ Nhan Dịch Ngữ chiêu đãi. Cậu nói xem có phải giờ cậu ta lắm tiền lắm không?”\n" +
                "\n" +
                "“Chắc làm đầu tư đều lắm tiền?” Hách Thúy Thúy không hiểu, dù sao thì Hách Đồng Quang đầu tư tiền sinh tiền, bất kể là bản thân, hay là đầu tư vào con người.\n" +
                "\n" +
                "Khương Vân gật gù trả lời, “Bây giờ sự nghiệp của cậu ta rất phát triển! Nữ cường nhân?”\n" +
                "\n" +
                "Nữ cường nhân? Hách Thúy Thúy nhét nửa miếng vịt nướng còn lại vào trong miệng, nghĩ thầm, nữ cường nhân này cùng với Hách Đồng Quang ngày ngày làm việc cùng nhau, không phải anh ấy sẽ càng tán thưởng cậu ta hơn sao?\n" +
                "\n" +
                "Vốn dĩ anh ấy đã rất tán thưởng cậu ta rồi!\n" +
                "\n" +
                "Hách Thúy Thúy nghiêng đầu nhìn, Hách Đồng Quang bị mấy tên con trai cầm cốc rượu vây quanh xin chỉ bảo mấy vấn đề liên quan đến cổ phiếu và ngân sách, hi vọng cho ít lời khuyên, tốt nhất chuẩn xác đến mức mua cái nào, bán cái nào…\n" +
                "\n" +
                "“Giám đốc Hách, tôi còn mua cổ phiếu của anh đó.”\n" +
                "\n" +
                "“Thế sao? Cảm ơn nhé.” Hách Đồng Quang khách sáo trả lời.\n" +
                "\n" +
                "“Ôi! Đừng khách sáo! Anh chính là người nhà mà, nhất định phải ủng hộ chứ!”\n" +
                "\n" +
                "Bên cạnh có người cầm điện thoại hỏi cổ phiếu Hách Đồng Quang quản lý là cái gì, người kia mở điện thoại ra đưa cho anh ta.\n" +
                "\n" +
                "Hách Thúy Thúy liếc mắt nhìn qua, tiền vốn 200………….\n" +
                "\n" +
                "“Ợ…” Hách Thúy Thúy che miệng, uống hai ngụm nước ngọt, nói muốn đi nhà vệ sinh. Khương Vân đang ăn cua, nói: “Cậu đi trước đi, tới theo sau ngay.”\n" +
                "\n" +
                "Hách Thúy Thúy đi vệ sinh xong, lúc ở bồn rửa tay gặp phải một người.\n" +
                "\n" +
                "Đúng, họp lớp nhìn thấy bạn trai cũ là bình thường. Cô cũng có bạn trai cũ! Nhưng hai người chia tay không hòa bình lắm, trong lòng Hách Thúy Thúy không muốn nói chuyện với anh ta.\n" +
                "\n" +
                "Cô học nữ nhân vật phản diện trong phim truyền hình không coi ai ra gì, nhìn thấy cũng coi như không thấy, hất cằm lên cao, đang định rời đi, Trương Dụ đột nhiên mở miệng.\n" +
                "\n" +
                "“Cô chơi tôi đấy à?”\n" +
                "\n" +
                "Hách Thúy Thúy: ???!!!\n" +
                "\n" +
                "Hách Thúy Thúy: “Anh nói linh tinh gì thế? Giống như tôi với anh có giao dịch gì đó vậy.”\n" +
                "\n" +
                "Làm ơn đi! Cô là người vợ tốt người vợ trong sạch có được không?\n" +
                "\n" +
                "Trương Dụ đẩy kính, mắt kính phản xạ ánh đèn trên đỉnh đầu, lóe lên khiến Hách Thúy Thúy hơi sợ hãi.\n" +
                "\n" +
                "Khương Tiểu Vân sao còn chưa đến? Hách Thúy Thúy hoảng sợ, nhà vệ sinh không một bóng người, quá giống hiện trường phạm tội?\n" +
                "\n" +
                "Cô nhìn khắp nơi, muốn tìm một món vũ khí thích hợp phòng thân, ai ngờ nghe thấy Trương Dụ hỏi, “Năm hai đại học cô đã kết hôn với Hách Đồng Quang rồi?”\n" +
                "\n" +
                "Hử? Hách Thúy Thúy không kịp thích ứng từ phim trường hành động sang phim trường tình cảm máu chó, đầu óc đần độn, “Là sao?”\n" +
                "\n" +
                "Bọn họ lúc đó không công khai, trừ những người bạn có quan hệ cực kỳ tốt ra, cũng không có nói cho người khác. Sau khi tốt nghiệp thì không cố ý che giấu, có người hỏi cô làm gì đó, cô đều nói đã kết hôn làm bà nội trợ.\n" +
                "\n" +
                "Cho nên hôm nay Trương Dụ mới biết.\n" +
                "\n" +
                "Nét mặt Trương Dụ từ tức giận sang phẫn nộ: “Tôi nói sao mà mỗi lần ra ngoài đều gặp phải Hách Đồng Quang, hai người dùng tôi làm chất xúc tác đúng không? Còn nói cái gì mà quan hệ anh em, có anh  em nhà ai mà kết hôn với nhau không?”\n" +
                "\n" +
                "Hách Thúy Thúy đúng là oan uổng, “Lúc đó thật không có gì có được không!” Tuy rằng hồi cấp hai bọn họ có chút abcz, nhưng sau này lớn hơn thì đã hiểu chuyện, không có làm cái kia nữa! Hai người đều giả như không có chuyện gì xảy ra!\n" +
                "\n" +
                "Trương Dụ thấy cô gấp đến mức giậm chân chỉ cảm thấy buồn cười. Hai năm hai sáu tuổi đầu rồi còn ăn đồ hồng phấn, tay áo đính ren sau đầu cài nơ con bướm như một đứa ngốc. Giống như hồi đại học, một chút thay đổi cũng không có, anh ta cười chế giễu, “Ánh mắt của Hách Đồng Quang đúng là kém, lại đi kết hôn với cô.”\n" +
                "\n" +
                "Hách Thúy Thúy gào lên, “Anh bị điên à! Mắt anh ấy tốt hơn mắt anh đó!” Cái gì cũng tốt hơn nhà mi!!!\n" +
                "\n" +
                "Năm đó đúng là cô bị mù rồi, mới cảm thấy hai người giống nhau!!!");
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
