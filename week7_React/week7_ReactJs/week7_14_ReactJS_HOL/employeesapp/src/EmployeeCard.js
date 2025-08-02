import Styles from './EmployeeCard.module.css';
import { useContext } from 'react';
import ThemeContext from './ThemeContext'; // ✅ Import context

function EmployeeCard(props) {
  const theme = useContext(ThemeContext); // ✅ Consume context

  return (
    <div className={Styles.Card}>
      <h3>{props.employee.name}</h3>
      <p>{props.employee.email}</p>
      <p>{props.employee.phone}</p>
      <p>
        <a href="#" className={theme}>Edit</a>
        <a href="#" className={theme}>Delete</a>
      </p>
    </div>
  );
}

export default EmployeeCard;
