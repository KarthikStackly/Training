function Appointments() {
    return (
        <form>
            <h1>Appointments</h1>
            <label>Your Name: </label>
            <input type="text" />
            <br /><br />
            <label>Department: </label>
            <select>
                <option>Select Department</option>
            </select>
            <br /><br />
            <label>Doctor: </label>
            <select>
                <option>Select Doctor</option>
            </select>
            <br /><br />
            <label>Select Date: </label>
            <input type="date" />
            <br /><br />
            <label>Select Time: </label>
            <input type="time" />
            <br /><br />
            <label>Reason: </label>
            <textarea></textarea>
            <br /><br />
            <button>Submit</button>
        </form>
    )
}

export default Appointments
