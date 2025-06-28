CREATE TABLE IF NOT EXISTS task_categories (
  category_id INTEGER PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL, 
  description TEXT,
  created_by INTEGER NOT NULL, -- Removed FOREIGN KEY keyword as it was incorrect syntax here
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, -- Timestamp when the task was last updated
  is_public TINYINT(1) DEFAULT 0, 
  is_deleted TINYINT(1) DEFAULT 0 
);

INSERT IGNORE INTO task_categories (name, created_by, description, created_at, updated_at, is_public, is_deleted)
VALUES 
('普通分类', 1, '普通任务分类', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1, 0),
('艾宾浩斯', 1, '艾宾浩斯记忆任务分类', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1, 0);
