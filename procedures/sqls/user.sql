CREATE TABLE IF NOT EXISTS user (
  user_id INTEGER PRIMARY KEY AUTOINCREMENT,
  username VARCHAR(30) NOT NULL UNIQUE,
  hashed_password VARCHAR(128) NOT NULL, -- 根据常见哈希算法调整长度
  email VARCHAR(50) NOT NULL UNIQUE,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  role VARCHAR(20) NOT NULL CHECK (role IN ('Admin', 'User', 'Moderator')), -- 添加约束
  is_deleted TINYINT(1) DEFAULT 0 -- 设置默认值
);

INSERT INTO users (username, hashed_password, email, role) VALUES
('john_doe', 'hashed_password_123', 'john.doe@example.com', 'Admin'),
('jane_smith', 'hashed_password_456', 'jane.smith@example.com', 'User'),
('alice_jones', 'hashed_password_789', 'alice.jones@example.com', 'Moderator');

