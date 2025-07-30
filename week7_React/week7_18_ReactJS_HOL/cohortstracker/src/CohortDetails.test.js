import React from 'react';
import { shallow, mount } from 'enzyme';
import CohortDetails from './CohortDetails';
import { CohortsData } from './Cohort';

describe('Cohort Details Component', () => {
  test('should create the component', () => {
    const wrapper = shallow(<CohortDetails cohort={CohortsData[0]} />);
    expect(wrapper.exists()).toBe(true);
  });

  test('should initialize the props', () => {
    const wrapper = mount(<CohortDetails cohort={CohortsData[1]} />);
    expect(wrapper.props().cohort).toEqual(CohortsData[1]);
  });

  test('should display cohort code in h3', () => {
    const wrapper = mount(<CohortDetails cohort={CohortsData[2]} />);
    expect(wrapper.find('h3').text()).toContain(CohortsData[2].cohortCode);
  });

  test('should always render same html', () => {
    const wrapper = shallow(<CohortDetails cohort={CohortsData[3]} />);
    expect(wrapper).toMatchSnapshot();
  });
});
