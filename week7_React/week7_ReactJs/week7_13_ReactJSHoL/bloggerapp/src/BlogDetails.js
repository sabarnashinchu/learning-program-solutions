import React from 'react';

const BlogDetails = ({ blogs }) => {
  return (
    <div className="v1">
      <h1>Blog Details</h1>
      {blogs && blogs.length > 0 ? ( // Conditional Rendering Method 2 (&& operator)
        blogs.map((blog, index) => (
          <div key={index}>
            <h2>{blog.title}</h2>
            <h4>{blog.author}</h4>
            <p>{blog.content}</p>
          </div>
        ))
      ) : (
        <p>No Blogs Available</p>
      )}
    </div>
  );
};

export default BlogDetails;
