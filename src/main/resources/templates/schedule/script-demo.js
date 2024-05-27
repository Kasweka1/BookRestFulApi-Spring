/**
 * @Author Francis Kalunga
 */

let durations = [];
let courseTimes = [];

const Days = {
    Mon: 'Monday',
    Tue: 'Tuesday',
    Wed: 'Wednesday',
    Thu: 'Thursday',
    Fri: 'Friday'
}

class Duration {
    constructor(starts, length) {
        this.starts = starts;
        this.length = length;
    }
    starts;
    length; // length in minutes
}

function createDurations(starts, number) {
    /**
     * To be used by programmer to automate:
     * 
     * const from8 = new Duration(8, 50)
     * const from9 = new Duration(9, 50)
     * ...
     */

    for (let i = 1; i <= number; i++) {
        let dur = new Duration(starts, 50);
        durations.push(dur);

        starts++;
    }
}

class CourseTime {
    constructor(duration, day) {
        this.duration = duration;
        this.day = day;
    }

    duration;
    day;
    occupied = false; // true if taken by course
}

class Location {
    constructor(name) {
        this.name = name
    }
    name
    free = {
        '07': true,
        '08': true,
        '09': true,
        '10': true,
        '11': true,
        '12': true,
        '13': true,
        '14': true,
        '15': true,
        '16': true,
        '17': true,
        '18': true
    }
}

class Course {
    constructor(courseID, courseName) {
        this.courseID = courseID;
        this.courseName = courseName;
    }

    courseID;
    courseName;
    courseTimes = [];

    init() {
        document.getElementById(this.courseID).addEventListener('click', () => {
            // show main view
            // document.getElementById('exp-course-viewer').innerHTML = ... just use setState to change which course is in view
            document.getElementById('exp-course-viewer').className = 'exp-course-viewer block';
        });
    }

    setCourseTime(courseTime) {
        // add courseTime to courseTimes array
        if (courseTime.occupied || lo) {
            console.error("Course time already taken")
            return
        }
        this.courseTimes.push(courseTime)
        courseTime.occupied = true
    }

    setCourseTime(courseTime) {
        // add courseTime to courseTimes array
        if (location.occupied) {
            console.error("Course time already taken")
            return
        }
        this.courseTimes.push(courseTime)
        courseTime.occupied = true
    }

    unsetCourseTime(courseTime) {
        // recreate courseTimes array after filtering out courseTime:
        this.courseTimes = this.courseTimes.filter(item => item !== courseTime);
        courseTime.occupied = false
    }
}

function hideExpCourseViewer() {
    document.getElementById('exp-course-viewer').className = 'exp-course-viewer hidden';
}

function createCourseTime(duration, day) {
    // Check if the CourseTime object already exists in the courseTimes array
    for (let i = 0; i < courseTimes.length; i++) {
        if (courseTimes[i].duration === duration && courseTimes[i].day === day) {
            console.log('CourseTime already exists:', courseTimes[i]);
            return; // If it exists, exit the function
        }
    }

    // If it doesn't exist, create a new CourseTime object and add it to the array
    let newCourseTime = new CourseTime(duration, day);
    courseTimes.push(newCourseTime);
    console.log('New CourseTime created:', newCourseTime);
}

// Schedule durations from 07:00 to 12:50 and from 14:00 to 17:50
createDurations(7, 6)
createDurations(14, 4)

console.log(durations)

/*
Days.forEach(key => {
   
});
*/
Object.keys(Days).forEach(key => {
    /**
     * For each day, initialize the schedule times
     */
    durations.forEach((duration) => {
        createCourseTime(duration, Days[key])
    })

  });


let csc3600 = new Course("csc3600", "Software Engineering")
let csc3301 = new Course("csc3301", "Programming languages")

csc3600.setCourseTime(courseTimes[0])
csc3301.setCourseTime(courseTimes[0])

class ScheduleInfo {
    constructor(startTime, courseName, venue) {
        this.startTime = startTime
        this.courseName = courseName
        this.venue = venue
    }

    startTime
    courseName
    venue
}

let simplifiedInfoHtml = (info) => `
<div class="item-p-div">
<p><span class="icon-span"><img src="./icons/clock.png" alt="icon" class="icon" /></span> &nbsp; <span
    class="text-span">Starts: ${info.startTime}</span></p>
<p><span class="icon-span"><img src="./icons/book.png" alt="icon" class="icon" /></span> &nbsp; <span
    class="text-span">Course: ${info.courseName}</span></p>
<p><span class="icon-span"><img src="./icons/location-pin.png" alt="icon" class="icon" /></span> &nbsp; <span
    class="text-span">Venue: ${info.venue}</span></p>
</div>
`

function addHtml(parent, child) {
    document.getElementById(parent).innerHTML += child
}

function addToSimplifiedSchedule(items) { // only fetch 3
    addHtml('now-span', simplifiedInfoHtml(items[0]))
    addHtml('next-span', simplifiedInfoHtml(items[1]))
    addHtml('after-span', simplifiedInfoHtml(items[2]))
}

let info1 = new ScheduleInfo("08:00", "SE", "CL2")
let info2 = new ScheduleInfo("11:00", "Algorithms", "SLH")
let info3 = new ScheduleInfo("14:00", "Programming", "GLT")

console.log(info1.courseName, info2.startTime, info3.venue)

addToSimplifiedSchedule([info1, info2, info3])

function populateSchedule() {
    
}


document.addEventListener('DOMContentLoaded', (event) => {
    const selectElement = document.getElementById('class-selection');

    selectElement.addEventListener('change', (event) => {
        const selectedValue = event.target.value;
        document.getElementById('selected-class').innerText = selectedValue
    });
});

/*
setTimeout(() => {
    document.get

}, 3600000) // update every hour 1h to ms = 1h*60m/h*60s/m*1000ms/s = 3 600 000ms
*/
