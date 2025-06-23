CREATE TABLE IF NOT EXISTS task_category (
  category_id INTEGER PRIMARY KEY AUTOINCREMENT,
  code VARCHAR(30) NOT NULL DEFAULT 'General' UNIQUE,
  name VARCHAR(30) NOT NULL, 
  description TEXT,
  created_by INTEGER NOT NULL, -- Removed FOREIGN KEY keyword as it was incorrect syntax here
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, -- Timestamp when the task was last updated
  is_deleted TINYINT(1) DEFAULT 0 -- 设置默认值
);

INSERT INTO task_categories (code, name, created_by, description, updated_at, is_deleted)
VALUES 
('General', '普通分类', 1, '普通任务分类', CURRENT_TIMESTAMP, 0),
('Ebbinghaus', '艾宾浩斯', 1, '艾宾浩斯记忆任务分类', CURRENT_TIMESTAMP, 0);
