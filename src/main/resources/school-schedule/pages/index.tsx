import { Inter } from "next/font/google";
import { useEffect, useState, ChangeEvent } from 'react';
import { Stream, CourseTime, Days, StartTimes } from "./api/models";
import { fetchCourseTime } from "./api/fetch.mjs";
import Image from "next/image";

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

    const d = 18;

    return (
      <td key={props.index} id={`${props.day}-${props.startTime}`} className="border p-2">
        <div className="flex">
          <span><Image src="/icons/clock.png" alt="clock-icon" width={d} height={d} /></span>
          <span className="ml-2">{courseTimeObject.courseCode}</span>
        </div>
        <div className="flex mt-2">
          <span><Image src="/icons/location-pin.png" alt="location-pin-icon" width={d} height={d} /></span>
          <span className="ml-2">{courseTimeObject.venue}</span>
        </div>
      </td>
    );
  };

  return (
    <>    <main className={` ${inter.className} block`}>
      <h1 className="w-full h-12 text-center p-2 bg-slate-100 text-slate-900 text-2xl sticky top-0 z-10">School Schedule</h1>
      <div className="sticky top-12 h-16 w-full bg-white block bg-white z-10">
        <section className="w-fit mx-auto flex">
          <span><h3 className="text-xl px-4 mt-4">{selectedStreamValue}</h3></span>
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
        </section>
      </div>
      <div className="sticky w-fit mx-auto ">
        <table>
          <thead className="sticky top-28">
            <tr>
              <th className="bg-slate-200 text-center"></th>
              {Days.map((day, index) => (
                <th key={index} id={day} className="bg-slate-200 px-2 py-1">{day}</th>
              ))}
            </tr>
          </thead>
          <tbody>
            {
              // Create as many rows as there are start times, for each row create as many cells as there are days
              StartTimes.map((startTime, outerIndex) => (
                <tr key={outerIndex}>
                  <td className="p-2">{startTime}</td>
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
      <footer className="bg-black w-full p-4 text-slate-100 mt-4">
        <div>
          <h3>Credits</h3>
          <p><span>Clock icon: </span>By <a className="underline" href="https://www.flaticon.com/authors/those-icons" title="Those Icons"> Those
            Icons </a> from <a className="underline" href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></p>
          <p><span>Book icon: </span>By <a className="underline" href="https://www.flaticon.com/authors/freepik" title="Freepik">
            Freepik </a> from <a className="underline" href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></p>
          <p><span>Location pin icon: </span>By <a className="underline" href="https://www.flaticon.com/authors/those-icons"
            title="Those Icons"> Those Icons </a> from <a className="underline" href="https://www.flaticon.com/"
              title="Flaticon">www.flaticon.com</a></p>
        </div>
      </footer>
    </>
  );
}
