import React from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';
import './App.css';

function App() {
  const books = [
    { id: 101, bname: 'Master React', price: 670 },
    { id: 102, bname: 'Deep Dive into Angular 11', price: 800 },
    { id: 103, bname: 'Mongo Essentials', price: 450 }
  ];

  const blogs = [
    { title: 'React Learning', author: 'Stephen Biz', content: 'Welcome to learning React!' },
    { title: 'Installation', author: 'Schewzdenier', content: 'You can install React from npm.' }
  ];

  const courses = [
    { name: 'Angular', date: '4/5/2021' },
    { name: 'React', date: '6/3/2021' }
  ];

  return (
    <div className="App">
      <div className="container">
        <CourseDetails courses={courses} />
        <BookDetails books={books} />
        <BlogDetails blogs={blogs} />
      </div>
    </div>
  );
}

export default App;
