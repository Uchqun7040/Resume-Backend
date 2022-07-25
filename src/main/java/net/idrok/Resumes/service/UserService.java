package net.idrok.Resumes.service;



import net.idrok.Resumes.entity.User;
import net.idrok.Resumes.service.dto.UserDTO;
import net.idrok.Resumes.service.vm.UserVM;


import java.util.List;
import java.util.Optional;

public interface UserService {
    public UserDTO create(User user);
    public List<UserDTO> getAll();
    public Boolean checkUsername(String username);
    public UserDTO getByUserName(String username);

}
