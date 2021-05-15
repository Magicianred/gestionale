import React from 'react'

const Spinner = ({children,style}) => {
    return (
        <div style={style}>
            {children}
        </div>
    )
}

export default Spinner