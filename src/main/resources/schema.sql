CREATE TABLE categories (
  category_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE idea (
    idea_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(250) NOT NULL,
    how VARCHAR(250) NOT NULL,
    why VARCHAR(250) NOT NULL,
    category VARCHAR(50) NOT NULL
    --FOREIGN KEY (category_id) REFERENCES categories(category_id)
);
