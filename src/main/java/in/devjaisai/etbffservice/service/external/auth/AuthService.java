package in.devjaisai.etbffservice.service.external.auth;

import in.devjaisai.etbffservice.service.model.AuthRequest;
import in.devjaisai.etbffservice.service.model.AuthResponse;

public interface AuthService {
  AuthResponse signUp(AuthRequest authRequest);
    }

