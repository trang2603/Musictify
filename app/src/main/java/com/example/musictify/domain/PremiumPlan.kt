package com.example.musictify.domain

import androidx.compose.ui.graphics.Color

data class PremiumPlan(
    val id: String,
    val name: String,
    val highlights: List<String>,
    val terms: String,
    val pricing: Pricing,
    val colorInfo: ColorInfo
) {
    data class Pricing(
        val associatedCardId: String,
        val cost: String,
        val term: String
    )

    data class ColorInfo(
        val gradientStart: Color,
        val gradientEnd: Color
    )
}

val defaultPremiumPlans = listOf(
    PremiumPlan(
        id = "premium_mini",
        name = "Gói Mini",
        highlights = listOf(
            "Gói 1 ngày và 1 tuần",
            "Nghe nhạc không quảng cáo trên di động",
            "Tải xuống 30 bài hát trên 1 thiết bị di động",
            "Gói chỉ dành cho di động"
        ),
        terms = "Giá thay đổi theo thời gian của gói. Áp dụng điều khoản và điều kiện.",
        pricing = PremiumPlan.Pricing(
            associatedCardId = "premium_mini",
            cost = "Từ 170.000 VNĐ",
            term = "1 ngày"
        ),
        colorInfo = PremiumPlan.ColorInfo(
            gradientStart = Color(0xFF4F99F4),
            gradientEnd = Color(0xFF2F4ABC)
        )
    ),
    PremiumPlan(
        id = "premium_individual",
        name = "Gói Cá Nhân",
        highlights = listOf(
            "Nghe nhạc không quảng cáo",
            "Tải xuống để nghe ngoại tuyến",
            "Chấp nhận thẻ ghi nợ và thẻ tín dụng"
        ),
        terms = "Ưu đãi chỉ dành cho người dùng mới của gói Premium. Áp dụng điều khoản và điều kiện.",
        pricing = PremiumPlan.Pricing(
            associatedCardId = "premium_individual",
            cost = "Miễn phí",
            term = "1 tháng"
        ),
        colorInfo = PremiumPlan.ColorInfo(
            gradientStart = Color(0xFF045746),
            gradientEnd = Color(0xFF16A96A)
        )
    ),
    PremiumPlan(
        id = "premium_duo",
        name = "Gói Premium Duo",
        highlights = listOf(
            "2 tài khoản Premium",
            "Dành cho cặp đôi sống chung",
            "Nghe nhạc không quảng cáo",
            "Tải xuống 10.000 bài hát trên thiết bị, tối đa 5 thiết bị mỗi tài khoản",
            "Chọn 1, 3, 6 hoặc 12 tháng Premium",
            "Chấp nhận thẻ ghi nợ và thẻ tín dụng"
        ),
        terms = "Ưu đãi chỉ dành cho người dùng mới của gói Premium. Áp dụng điều khoản và điều kiện.",
        pricing = PremiumPlan.Pricing(
            associatedCardId = "premium_duo",
            cost = "Miễn phí",
            term = "1 tháng"
        ),
        colorInfo = PremiumPlan.ColorInfo(
            gradientStart = Color(0xff5992C2),
            gradientEnd = Color(0xff3F3F76)
        )
    ),
    PremiumPlan(
        id = "premium_family",
        name = "Gói Premium Gia Đình",
        highlights = listOf(
            "Nghe nhạc không quảng cáo",
            "Chọn 1, 3, 6 hoặc 12 tháng Premium",
            "Chấp nhận thẻ ghi nợ và thẻ tín dụng"
        ),
        terms = "Ưu đãi chỉ dành cho người dùng mới của gói Premium. Áp dụng điều khoản và điều kiện.",
        pricing = PremiumPlan.Pricing(
            associatedCardId = "premium_family",
            cost = "Miễn phí",
            term = "1 tháng"
        ),
        colorInfo = PremiumPlan.ColorInfo(
            gradientStart = Color(0xFF213265),
            gradientEnd = Color(0xFF972A8E)
        )
    ),
    PremiumPlan(
        id = "premium_student",
        name = "Gói Premium Sinh Viên",
        highlights = listOf(
            "Nghe nhạc không quảng cáo",
            "Tải xuống để nghe ngoại tuyến"
        ),
        terms = "Ưu đãi chỉ dành cho sinh viên tại các cơ sở giáo dục đại học được công nhận. Áp dụng điều khoản và điều kiện.",
        pricing = PremiumPlan.Pricing(
            associatedCardId = "premium_student",
            cost = "Miễn phí",
            term = "1 tháng"
        ),
        colorInfo = PremiumPlan.ColorInfo(
            gradientStart = Color(0xFFF49A24),
            gradientEnd = Color(0xFFB27049)
        )
    )
)