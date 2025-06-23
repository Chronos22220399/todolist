CREATE TABLE IF NOT EXISTS todo (
  task_id INTEGER PRIMARY KEY AUTOINCREMENT,
  title VARCHAR(50) NOT NULL, -- Task title, mandatory field
  catogory_id INTEGER NOT NULL,
  description TEXT, -- Detailed description of the task
  status VARCHAR(20) DEFAULT "Completed" CHECK (status IN ("Completed", "Not Completed", "Archived")), -- Task status: Completed, Not Completed, Archived
  priority INTEGER DEFAULT 0 CHECK (priority IN (0, 1, 2)), -- Task priority: 0 - low, 1 - middle, 2 - high
  created_by INTEGER, -- ID of the user who created the task
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, -- Timestamp when the task was created
  updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, -- Timestamp when the task was last updated
  is_deleted TINYINT(1) DEFAULT 0, -- 设置默认值
  FOREIGN KEY (created_by) REFERENCES users(user_id), -- Foreign key constraint linking created_by to users table
  FOREIGN KEY (catogory_id) REFERENCES users(task_catogories) -- Foreign key constraint linking created_by to users table
);

