export const Days = [
    'Monday',
    'Tuesday',
    'Wednesday',
    'Thursday',
    'Friday'
]

export const StartTimes = [
    "07:00",
    "08:00",
    "09:00",
    "10:00",
    "11:00",
    "12:00",
    "13:00",
    "14:00",
    "15:00",
    "16:00",
    "17:00",
    "18:00"
]

export type Course = {
    code: string,
    name: string,
    year: number
}

export type Stream = {
    name: string
}

export type CourseTime = {
    time: string,
    day: string,
    venue: string,
    courseCode: string,
    stream: string,
    type: "Class" | "Lab" | "Tutorial"
}