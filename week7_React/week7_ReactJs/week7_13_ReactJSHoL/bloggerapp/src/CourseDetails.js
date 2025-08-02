import React from 'react';

const CourseDetails = ({ courses }) => {
  const showCourses = courses.length > 0; // Conditional Rendering Method 3 (if-else)
  
  return (
    <div className="mystyle1">
      <h1>Course Details</h1>
      {showCourses ? (
        courses.map((course, index) => (
          <div key={index}>
            <h3>{course.name}</h3>
            <h4>{course.date}</h4>
          </div>
        ))
      ) : (
        <p>No Courses Available</p>
      )}
    </div>
  );
};

export default CourseDetails;
