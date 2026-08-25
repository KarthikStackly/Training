function DoctorCard({ doc }) {
    return (
        <div>
            <h2>{doc.firstName}</h2>
            <img src={doc.image} />
            <button>View Profile</button>
        </div>
    )
}

export default DoctorCard
