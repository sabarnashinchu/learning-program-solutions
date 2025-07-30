import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        const postList = data.map(post => new Post(post.id, post.title, post.body));
        this.setState({ posts: postList });
      })
      .catch(error => {
        console.error("Fetch error:", error);
        alert("Failed to fetch posts.");
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    this.setState({ hasError: true });
    alert("An error occurred in Posts component.");
    console.error("Error caught in componentDidCatch:", error, info);
  }

  render() {
    const { posts, hasError } = this.state;

    if (hasError) {
      return <h3>Something went wrong while loading posts.</h3>;
    }

    return (
      <div>
        <h2>Posts</h2>
        {posts.map(post => (
          <div key={post.id}>
            <h4>{post.title}</h4>
            <p>{post.body}</p>
            <hr />
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
