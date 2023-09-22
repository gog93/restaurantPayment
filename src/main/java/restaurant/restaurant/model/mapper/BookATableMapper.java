package restaurant.restaurant.model.mapper;

import restaurant.restaurant.model.BookATable;
import restaurant.restaurant.model.dto.request.RequestBookATable;
import restaurant.restaurant.model.dto.response.ResponseBookATable;

public class BookATableMapper {
    public static BookATable mapToBookATable(ResponseBookATable bookATableDto) {
        return BookATable.builder()
                .user(bookATableDto.getUser())
                .time(bookATableDto.getTime())
                .space(bookATableDto.getSpace())
                .feeAmount(bookATableDto.getFeeAmount())
                .foods(bookATableDto.getFoods())
                .build();
    }

    public static RequestBookATable mapToRequestBookATable(BookATable bookATable) {
        return RequestBookATable.builder()
                .id(bookATable.getId())
                .user(bookATable.getUser())
                .time(bookATable.getTime())
                .space(bookATable.getSpace())
                .feeAmount(bookATable.getFeeAmount())
                .foods(bookATable.getFoods())
                .build();
    }

    public static ResponseBookATable mapToResponseBookATable(BookATable bookATable) {
        return ResponseBookATable.builder()
                .user(bookATable.getUser())
                .time(bookATable.getTime())
                .space(bookATable.getSpace())
                .feeAmount(bookATable.getFeeAmount())
                .space(bookATable.getSpace())
                .build();
    }
}
