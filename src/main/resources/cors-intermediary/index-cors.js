/**
 * @author Francis Kalunga
 */
import express from 'express';
import cors from 'cors';

const app = express();
const PORT = process.env.PORT || 4000;

// Enable CORS for all routes
app.use(cors());

const streams = {
  se: "Software Engineering",
  sys: "Computer Systems",
  net: "Computer Networking"
}

const courseUnits = [
  {
    time: '08:00',
    day: 'Monday',
    venue: 'SLH',
    courseCode: 'CSC3600',
    streams: ['Software Engineering'],
    type: 'Class'
  },
  {
    time: '09:00',
    day: 'Monday',
    venue: 'GLT',
    courseCode: 'CSC3600',
    streams: ['Software Engineering'],
    type: 'Class'
  },
  {
    time: '14:00',
    day: 'Monday',
    venue: 'CL2',
    courseCode: 'CSC3600',
    streams: ['Software Engineering'],
    type: 'Lab'
  },
  {
    time: '08:00',
    day: 'Tuesday',
    venue: 'GLT',
    courseCode: 'CSC3011',
    streams: ['Software Engineering', 'Computer Systems'],
    type: 'Class'
  },
  {
    time: '11:00',
    day: 'Tuesday',
    venue: 'GLT',
    courseCode: 'CSC3301',
    streams: [
      'Software Engineering',
      'Computer Systems',
      'Computer Networking'
    ],
    type: 'Class'
  },
  {
    time: '08:00',
    day: 'Wednesday',
    venue: 'CL2',
    courseCode: 'CSC3210',
    streams: ['Computer Systems'],
    type: 'Class'
  },
  {
    time: '12:00',
    day: 'Wednesday',
    venue: 'SLH',
    courseCode: 'CSC3301',
    streams: ['Computer Systems'],
    type: 'Class'
  },
  {
    time: '08:00',
    day: 'Thursday',
    venue: 'GLT',
    courseCode: 'CSC3801',
    streams: [
      'Software Engineering',
      'Computer Systems',
      'Computer Networking'
    ],
    type: 'Class'
  },
  {
    time: '09:00',
    day: 'Thursday',
    venue: 'GLT',
    courseCode: 'CSC3801',
    streams: [
      'Software Engineering',
      'Computer Systems',
      'Computer Networking'
    ],
    type: 'Class'
  },
  {
    time: '08:00',
    day: 'Friday',
    venue: 'CL2',
    courseCode: 'CSC3600',
    streams: ['Software Engineering'],
    type: 'Class'
  },
  {
    time: '09:00',
    day: 'Friday',
    venue: 'CL2',
    courseCode: 'CSC3600',
    streams: ['Software Engineering'],
    type: 'Class'
  }
];


app.get('/api/streams', async (req, res) => {
  /*
  let streams = await fetch('http://localhost:8080/api/scheduler/streams')
    .then(response => response.json())
    .then(results => results)
  */
  res.json(streams);
});

app.get('/api/coursetimes/:stream', async (req, res) => {

  const { stream } = req.params;

  let filteredCourseUnits = await fetch('http://localhost:8080/api/scheduler/coursetimes')
    .then(response => response.json())
    .then(objectArray => objectArray.filter(object => object["streams"].includes(stream)))

    res.json(filteredCourseUnits);
})

// Start the server
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
