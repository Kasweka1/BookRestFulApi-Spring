const Day = {
    mon: 'Monday',
    tue: 'Tuesday',
    wed: 'Wednesday',
    thu: 'Thursday',
    fri: 'Friday'
}

type Course = {
    code: string,
    name: string,
    year: number
}

type Stream = {
    name: string
}

type Type = {
    type: "Class" | "Lab" | "Tutorial"
}

type Course_Time = {
    time: string,
    day: string,
    venue: string,
    course_code: string,
    type: Type
}