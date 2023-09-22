package restaurant.restaurant.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restaurant.restaurant.model.Admin;
import restaurant.restaurant.model.dto.request.RequestAdmin;
import restaurant.restaurant.model.dto.response.ResponseAdmin;
import restaurant.restaurant.model.mapper.AdminMapper;
import restaurant.restaurant.rest.repository.AdminRepository;
import restaurant.restaurant.rest.service.AdminService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Override
    public void saveAdmin(ResponseAdmin admin) {
        adminRepository.save(AdminMapper.mapToAdmin(admin));

    }

    @Override
    public RequestAdmin findById(Long id) {
        return AdminMapper.mapToRequestAdmin(adminRepository.findById(id).get());
    }

    @Override
    public Optional<RequestAdmin> findByEmail(String email) {
        Optional<Admin> admin=adminRepository.findByEmail(email);
        return admin.map(reqAdmin -> AdminMapper.mapToRequestAdmin(reqAdmin));
    }

    @Override
    public List<RequestAdmin> findAll() {
        return null;
    }
}
