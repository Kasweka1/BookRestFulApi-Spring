import { Inter } from "next/font/google";
import { useEffect, useState, ChangeEvent } from 'react';
import { Stream, CourseTime, Days, StartTimes } from "./api/models";
import { fetchCourseTime } from "./api/fetch.mjs";

const inter = Inter({ subsets: ["latin"] });

export default function Home() {
  const [streamData, setStreamData] = useState<Stream[]>([]);
  const [selectedStreamValue, setSelectedStreamValue] = useState<string>('');
  const [courseTimeData, setCourseTimeData] = useState<CourseTime[]>([]);

  useEffect(() => {
    const fetchStreamData = async () => {
      const res = await fetch('http://localhost:4000/api/streams'); // or any other endpoint
      const rawData = await res.json();

      // Transform the rawData object into an array of key-value pairs
      const entries = Object.entries(rawData);

      // Map over the entries to create an array of Stream objects
      const mappedData: Stream[] = entries.map(([key, value]) => ({
        key: key,
        name: value as string
      }));

      setStreamData(mappedData);
    };

    fetchStreamData();
  }, []);

  const fetchCourseTimeData = async (streamValue: string) => {
    const res = await fetch(`http://localhost:4000/api/course-units/${streamValue}`); // or any other endpoint
    const rawData = await res.json();

    // Transform the rawData object into an array of key-value pairs
    const entries = Object.entries(rawData);

    // Map over the entries to create an array of CourseTime objects
    const mappedData: CourseTime[] = entries.map(([key, value]) => ({
      key: key,
      time: value.time as string,
      day: value.day as string,
      venue: value.venue as string,
      courseCode: value.courseCode as string,
      stream: value.stream as string,
      type: value.type as string
    }));

    // console.log("mappedData = ", mappedData);

    setCourseTimeData(mappedData);

    // console.log("courseTimeData = ", courseTimeData);
  };

  const handleStreamChange = (event: ChangeEvent<HTMLSelectElement>) => {
    const value = event.target.value;
    setSelectedStreamValue(value);
    // console.log(value); // Log the selected value
    fetchCourseTimeData(value); // Fetch course time data for the selected stream
  };

  const ScheduleCell = (props: { index: number, day: string, startTime: string }) => {
    let courseTimeObject: CourseTime | undefined = courseTimeData.find((courseTimeDataObject) => courseTimeDataObject.day === props.day && courseTimeDataObject.time === props.startTime);
    if (!courseTimeObject) {
      courseTimeObject = {
        time: '',
        day: '',
        venue: '',
        courseCode: '',
        stream: '',
        type: 'Class'
      };
    }
    return (
      <td key={props.index} id={`${props.day}-${props.startTime}`} className="border">
        <p>{courseTimeObject.courseCode}</p>
        <p>{courseTimeObject.venue}</p>
      </td>
    );
  };

  return (
    <main className={` ${inter.className}`}>
      <h1 className="w-full text-center p-4 text-slate-900 text-2xl sticky top-0">School Schedule</h1>
      <div className="stick top-18 w-full flex">
        <span><h3>{selectedStreamValue}</h3></span>
        <span className="right-2.5">
          <select
            value={selectedStreamValue}
            onChange={handleStreamChange}
            className="m-2 p-2 border rounded-md"
            id="stream-selector"
          >
            <option value="" disabled>Select your major</option>
            {
              streamData.map((stream, index) => (
                <option key={index} value={stream.name}>{stream.name}</option>
              ))
            }
          </select>
        </span>
      </div>
      <div>
        <table>
          <thead>
            <tr>
              <th className="bg-slate-200"></th>
              {Days.map((day, index) => (
                <th key={index} id={day} className="bg-slate-200">{day}</th>
              ))}
            </tr>
          </thead>
          <tbody>
            {
              // Create as many rows as there are start times, for each row create as many cells as there are days
              StartTimes.map((startTime, outerIndex) => (
                <tr key={outerIndex}>
                  <td>{startTime}</td>
                  {
                    Days.map((day, innerIndex) => (
                      <ScheduleCell
                        index={innerIndex}
                        day={day}
                        startTime={startTime}
                      />
                    ))
                  }
                </tr>
              ))
            }
          </tbody>
        </table>
      </div>
    </main>
  );
}
