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

app.get('/api/streams', async (req, res) => {
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
