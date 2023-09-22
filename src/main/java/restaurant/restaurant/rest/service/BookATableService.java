package restaurant.restaurant.rest.service;

import restaurant.restaurant.model.dto.request.RequestBookATable;
import restaurant.restaurant.model.dto.response.ResponseBookATable;

import java.util.List;

public interface BookATableService {
    void saveBookATable(ResponseBookATable responseBookATable, Long userId);

    RequestBookATable findById(Long id);


    List<RequestBookATable> findAll();
}
