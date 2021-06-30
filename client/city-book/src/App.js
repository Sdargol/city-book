import './App.css';

import { getAllCities , 
  getAllSortedCities, 
  getAllSortedDistrictNameCities, 
  getMaxPopulationCity,
  getPopulationRegion} from './api/CityBookAPI';

import { useEffect, useState } from 'react';

function App() {
  const [value, setValue] = useState(1);
  
  const [value1, setValue1] = useState({});
  
  useEffect(() => {
    console.log("Update")
  }, [value]);
  
  return (
    <div className="App">
      <header className="App-header">

        <div className="App-button-container">
          <button className="App-button" 
            onClick={()=>{
              setValue({a : "a"});
              getAllCities()}}>getAllCities</button>

          <button className="App-button" 
            onClick={()=>{
              setValue1({b: "b"});
              getAllSortedCities()}}>getAllSortedCities</button>

          <button className="App-button" 
            onClick={()=>{getAllSortedDistrictNameCities()}}>getAllSortedDistrictNameCities</button>

          <button className="App-button" 
            onClick={()=>{getMaxPopulationCity()}}>getMaxPopulationCity</button>

          <button className="App-button" 
            onClick={()=>{getPopulationRegion()}}>getPopulationRegion</button>
        </div>

      </header>
    </div>
  );
}

export default App;
