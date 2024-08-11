package com.codedecode.userInfo.mapper;

import com.codedecode.userInfo.dto.UserDTO;
import com.codedecode.userInfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper((UserMapper.class));

    // Map UserDTO to User entity
    User mapUserDTOToUser(UserDTO userDTO);

    // Map User Entity to UserDTO
    UserDTO mapUserToUserDTO(User user);


}
