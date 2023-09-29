import Navbar from '@/components/Navbar'
import styles from './Template.module.scss'
import React from 'react'

export default function Template({ children }: { children: React.ReactElement }) {
    return(
        <div className={styles.main}>
            <Navbar />
            {children}
        </div>
    )
}