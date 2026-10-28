package com.example.videos.service;

import com.example.videos.dto.AddressRequestDTO;
import com.example.videos.entity.User;
import com.example.videos.entity.Role;
import com.example.videos.entity.Address;
import com.example.videos.enums.RoleEnum;
import com.example.videos.repository.UserRepository;
import com.example.videos.repository.RoleRepository;
import com.example.videos.dto.UserUpdateDTO;
import com.example.videos.dto.UserRequestDTO;
import com.example.videos.dto.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private UserResponseDTO toResponseDTO(User user) {

        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole().getRole());

        return dto;
    }

    @Transactional(readOnly = true)
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public UserResponseDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(this::toResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User with ID " + id + " not found"
                ));
    }

    @Transactional
    public UserResponseDTO createUser(UserRequestDTO request) {
        User user = new User();

        // Check if the username is already in use
        if (request.getUsername() != null
            && !request.getUsername().isBlank()
            && userRepository.existsByUsername(request.getUsername())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Username " + request.getUsername() + " is already in use"
            );
        }

        user.setUsername(
                request.getUsername() != null && !request.getUsername().isBlank()
                        ? request.getUsername()
                        : null
        );

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        // Check if the email is already in use
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email " + request.getEmail() + " is already in use"
            );
        }

        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setBirthdate(request.getBirthdate());

        // Hash the password before saving
        user.setPassword(
passwordEncoder.encode(request.getPassword())
        );


        // Set the role to "USER" by default
        Role role = roleRepository.findByRole(RoleEnum.USER)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "Default role USER not found"
                ));
        user.setRole(role);

        // Add address if provided
        if (request.getAddress() != null) {

            AddressRequestDTO addressRequest = request.getAddress();

            Address address = new Address();

            address.setNumber(addressRequest.getNumber());
            address.setStreet(addressRequest.getStreet());
            address.setCity(addressRequest.getCity());
            address.setZipCode(addressRequest.getZipCode());
            address.setCountry(addressRequest.getCountry());

            user.setAddress(address);
        }

        User savedUser = userRepository.save(user);

        return toResponseDTO(savedUser);
    }

    @Transactional
    public UserResponseDTO updateUser(Long id, UserUpdateDTO request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User with ID " + id + " not found"
                ));

        // Check if the username is already in use by another user
        if (request.getUsername() != null
            && !request.getUsername().isBlank()
            && !Objects.equals(user.getUsername(), request.getUsername())
            && userRepository.existsByUsername(request.getUsername())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Username " + request.getUsername() + " is already in use"
            );
        }

        user.setUsername(
                request.getUsername() != null && !request.getUsername().isBlank()
                        ? request.getUsername()
                        : null
        );

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        // Check if the email is already in use by another user
        if (!user.getEmail().equals(request.getEmail())
            && userRepository.existsByEmail(request.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email " + request.getEmail() + " is already in use"
            );
        }

        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setBirthdate(request.getBirthdate());

        // Update address if provided
        if (request.getAddress() != null) {

            AddressRequestDTO addressRequest = request.getAddress();

            Address address = Optional.ofNullable(user.getAddress())
                    .orElseGet(Address::new);

            address.setNumber(addressRequest.getNumber());
            address.setStreet(addressRequest.getStreet());
            address.setCity(addressRequest.getCity());
            address.setZipCode(addressRequest.getZipCode());
            address.setCountry(addressRequest.getCountry());

            user.setAddress(address);
        }

        User updatedUser = userRepository.save(user);

        return toResponseDTO(updatedUser);
    }

    @Transactional
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User with ID " + id + " not found"
                ));
        userRepository.delete(user);
    }
}
