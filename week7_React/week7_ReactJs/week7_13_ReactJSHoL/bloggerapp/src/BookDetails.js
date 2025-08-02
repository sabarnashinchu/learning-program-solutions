import React from 'react';

const BookDetails = ({ books }) => {
  return (
    <div className="st2">
      <h1>Book Details</h1>
      <ul>
        {books.length > 0 ? ( // Conditional Rendering Method 1
          books.map((book) => (
            <div key={book.id}>
              <h3>{book.bname}</h3>
              <h4>{book.price}</h4>
            </div>
          ))
        ) : (
          <p>No Books Available</p>
        )}
      </ul>
    </div>
  );
};

export default BookDetails;
