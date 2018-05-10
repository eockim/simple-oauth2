INSERT INTO oauth_user (password, user_name) VALUES
  ('{bcrypt}$2a$10$I7jfTyeOCRG8FEelckxNCeiWAioFZKa/wVP1p3e1KVV5sRfRb5/N2', 'user'),
  ('{bcrypt}$2a$10$I7jfTyeOCRG8FEelckxNCeiWAioFZKa/wVP1p3e1KVV5sRfRb5/N2', 'user2');

TRUNCATE oauth_client_details;