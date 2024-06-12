'use client';

function fetchStreams() {
    fetch('http://localhost:8080/api/scheduler/streams')
        .then(response => response.json())
        .then(data => {
            console.log("streams data form java server: ", data)
            console.log(typeof data)
        });
}

async function fetchCourseTimes() {
    const response = await fetch('http://localhost:8080/api/scheduler/coursetimes');
  
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
  
    const data = await response.json();
    return data;
  }
// fetchStreams();
// fetchCourseTimes();
console.log("coursetimes data form java server: ", fetchCourseTimes())