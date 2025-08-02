import axios from 'axios';
import GitClient from './GitClient';

jest.mock('axios');

describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    const mockData = [
      { id: 1, name: 'RepoOne' },
      { id: 2, name: 'RepoTwo' }
    ];

    axios.get.mockResolvedValue({ data: mockData });

    const response = await GitClient.getRepositories('techiesyed');

    expect(response.data).toEqual(mockData);
    expect(axios.get).toHaveBeenCalledWith('https://api.github.com/users/techiesyed/repos');
  });
});
