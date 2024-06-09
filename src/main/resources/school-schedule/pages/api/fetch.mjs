function fetch(path) {
    fetch(`/${path}`)
        .then(response => response.json())
        .then(data => {
            return data
        })
}

export async function fetchCourses() {
    let courses = await fetch('course')
    return courses
}

export async function fetchStreams() {
    let streams = await fetch('streams')
    return streams
}

export async function fetchCourseTime() {
    let courseTimes = await fetch('course-unit')
    return courseTimes
}