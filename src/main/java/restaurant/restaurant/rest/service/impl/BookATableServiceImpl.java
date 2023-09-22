package restaurant.restaurant.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restaurant.restaurant.model.dto.request.RequestBookATable;
import restaurant.restaurant.model.dto.request.RequestUser;
import restaurant.restaurant.model.dto.response.ResponseBookATable;
import restaurant.restaurant.model.mapper.BookATableMapper;
import restaurant.restaurant.model.mapper.UserMapper;
import restaurant.restaurant.rest.repository.BookATableRepository;
import restaurant.restaurant.rest.service.BookATableService;
import restaurant.restaurant.rest.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookATableServiceImpl implements BookATableService {
    private final BookATableRepository bookATableRepository;
    private final UserService userService;

    @Override
    public void saveBookATable(ResponseBookATable bookATable, Long userId) {
        RequestUser byId = userService.findById(userId);
        bookATable.setUser(UserMapper.mapToUserFromRequestUser(byId));
        bookATableRepository.save(BookATableMapper.mapToBookATable(bookATable));

    }

    @Override
    public RequestBookATable findById(Long id) {
        return BookATableMapper.mapToRequestBookATable(bookATableRepository.findById(id).get());
    }


    @Override
    public List<RequestBookATable> findAll() {
        return null;
    }
}
